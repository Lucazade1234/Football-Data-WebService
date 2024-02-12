package com.example.demo.models;

public class Teaminfo {
    private int id;
    private String name;
    private String logo;
    private boolean winner;

    public Teaminfo(int id, String name, String logo, boolean winner) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
