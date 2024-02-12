package com.example.demo.models;

public class Penalty {
    private Integer home; // Integer to allow null value
    private Integer away; // Integer to allow null value

    public Penalty(Integer home, Integer away) {
        this.home = home;
        this.away = away;
    }

    public Integer getHome() {
        return home;
    }

    public void setHome(Integer home) {
        this.home = home;
    }

    public Integer getAway() {
        return away;
    }

    public void setAway(Integer away) {
        this.away = away;
    }
}
