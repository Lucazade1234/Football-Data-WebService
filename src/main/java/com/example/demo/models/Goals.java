package com.example.demo.models;

public class Goals {
    private int home;
    private int away;


    public Goals(int home, int away) {
        this.home = home;
        this.away = away;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getAway() {
        return away;
    }

    public void setAway(int away) {
        this.away = away;
    }
}
