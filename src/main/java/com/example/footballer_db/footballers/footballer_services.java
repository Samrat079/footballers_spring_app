package com.example.footballer_db.footballers;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class footballer_services {

    public footballer_repository footballerRepository;
    private final MongoTemplate mongoTemplate;

    public footballer_services(MongoTemplate mongoTemplate, footballer_repository footballerRepository) {
        this.mongoTemplate = mongoTemplate;
        this.footballerRepository = footballerRepository;
    }

    Optional<Footballer> getFootBallerById(String id) {
        return footballerRepository.findById(id);
    }

    void addFootBaller(Footballer body) {
        footballerRepository.insert(body);
    }

    void updateFootBaller(String id, Footballer body) {
        Optional<Footballer> temp = footballerRepository.findById(id);

        if (temp.isEmpty()) return;
        body.setId(id);
        footballerRepository.save(body);
    }

    void deleteFootBaller(String id) {
        footballerRepository.deleteById(id);
    }

    public List<Footballer> advanced_search(Map<String, String> params) {

        if (params.containsKey("query")) {
            return footballerRepository.search(params.get("query"));
        }

        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        addRegexCriteria(criteriaList, params, "player");
        addRegexCriteria(criteriaList, params, "team");
        addRegexCriteria(criteriaList, params, "nation");
        addRegexCriteria(criteriaList, params, "pos");

        params.forEach((key, value) -> {
            if (key.endsWith("_gt")) {
                criteriaList.add(Criteria.where(removeSuffix(key, "_gt"))
                        .gt(parseNumber(value)));
            }

            if (key.endsWith("_gte")) {
                criteriaList.add(Criteria.where(removeSuffix(key, "_gte"))
                        .gte(parseNumber(value)));
            }

            if (key.endsWith("_lt")) {
                criteriaList.add(Criteria.where(removeSuffix(key, "_lt"))
                        .lt(parseNumber(value)));
            }

            if (key.endsWith("_lte")) {
                criteriaList.add(Criteria.where(removeSuffix(key, "_lte"))
                        .lte(parseNumber(value)));
            }
        });

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(
                    criteriaList.toArray(new Criteria[0])
            ));
        }

        return mongoTemplate.find(query, Footballer.class);
    }

    private void addRegexCriteria(List<Criteria> criteriaList, Map<String, String> params, String field) {
        if (params.containsKey(field)) {
            criteriaList.add(Criteria.where(field).regex(params.get(field), "i"));
        }
    }

    private String removeSuffix(String key, String suffix) {
        return key.substring(0, key.length() - suffix.length());
    }

    private Number parseNumber(String value) {
        if (value.contains(".")) {
            return Double.parseDouble(value);
        }
        return Integer.parseInt(value);
    }
}
