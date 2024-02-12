package com.example.demo.models;

public class Teams {
    private Teaminfo home;
    private Teaminfo away;

    public Teams(Teaminfo home, Teaminfo away) {
        this.home = home;
        this.away = away;
    }

    public Teaminfo getHome() {
        return home;
    }

    public void setHome(Teaminfo home) {
        this.home = home;
    }

    public Teaminfo getAway() {
        return away;
    }

    public void setAway(Teaminfo away) {
        this.away = away;
    }
}
