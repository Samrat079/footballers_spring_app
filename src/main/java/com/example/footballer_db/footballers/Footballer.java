package com.example.footballer_db.footballers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "footballer")
public class Footballer {
    @Id
    private String id;

    @TextIndexed
    private String player;

    private String nation, pos, team;

    private int age, mp, starts, min, gls, ast, pk, crdY, crdR;

    private double xG, xAG;

    public Footballer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStarts() {
        return starts;
    }

    public void setStarts(int starts) {
        this.starts = starts;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getGls() {
        return gls;
    }

    public void setGls(int gls) {
        this.gls = gls;
    }

    public int getAst() {
        return ast;
    }

    public void setAst(int ast) {
        this.ast = ast;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getCrdY() {
        return crdY;
    }

    public void setCrdY(int crdY) {
        this.crdY = crdY;
    }

    public int getCrdR() {
        return crdR;
    }

    public void setCrdR(int crdR) {
        this.crdR = crdR;
    }

    public double getxG() {
        return xG;
    }

    public void setxG(double xG) {
        this.xG = xG;
    }

    public double getxAG() {
        return xAG;
    }

    public void setxAG(double xAG) {
        this.xAG = xAG;
    }
}

//        "Player": "Gabriel Dos Santos",
//        "Nation": "br BRA",
//        "Pos": "DF",
//        "Age": 24,
//        "MP": 14, Matches played
//        "Starts": 14, Matches started
//        "Min": 1260, Total minutes played
//        "Gls": 2, total goals
//        "Ast": 0, Total Assists
//        "PK": 0, Penalty goal
//        "CrdY": 2, Yellow cards
//        "CrdR": 0, Red cards
//        "xG": 2.3, Expected goals
//        "xAG": 0.2, expected assists
//        "Team": "Arsenal"
