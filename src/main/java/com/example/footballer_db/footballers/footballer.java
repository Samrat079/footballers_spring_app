package com.example.footballer_db.footballers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "footballer")
public class footballer {
    @Id
    private String id;

    @TextIndexed
    private String Player;

    private String Nation, Pos, Team;

    private int Age, MP, Starts, Min, Gls, Ast, PK, CrdY, CrdR;

    private double xG, xAG;

    public footballer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayer() {
        return Player;
    }

    public void setPlayer(String player) {
        Player = player;
    }

    public String getNation() {
        return Nation;
    }

    public void setNation(String nation) {
        Nation = nation;
    }

    public String getPos() {
        return Pos;
    }

    public void setPos(String pos) {
        Pos = pos;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getStarts() {
        return Starts;
    }

    public void setStarts(int starts) {
        Starts = starts;
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int min) {
        Min = min;
    }

    public int getGls() {
        return Gls;
    }

    public void setGls(int gls) {
        Gls = gls;
    }

    public int getAst() {
        return Ast;
    }

    public void setAst(int ast) {
        Ast = ast;
    }

    public int getPK() {
        return PK;
    }

    public void setPK(int PK) {
        this.PK = PK;
    }

    public int getCrdY() {
        return CrdY;
    }

    public void setCrdY(int crdY) {
        CrdY = crdY;
    }

    public int getCrdR() {
        return CrdR;
    }

    public void setCrdR(int crdR) {
        CrdR = crdR;
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
