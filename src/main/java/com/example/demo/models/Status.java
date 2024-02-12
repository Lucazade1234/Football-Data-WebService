package com.example.demo.models;

public class Status {
    private String longStatus;
    private String shortStatus;
    private int elapsed;

    // Getters and setters


    public Status(String longStatus, String shortStatus, int elapsed) {
        this.longStatus = longStatus;
        this.shortStatus = shortStatus;
        this.elapsed = elapsed;
    }

    public String getLongStatus() {
        return longStatus;
    }

    public void setLongStatus(String longStatus) {
        this.longStatus = longStatus;
    }

    public String getShortStatus() {
        return shortStatus;
    }

    public void setShortStatus(String shortStatus) {
        this.shortStatus = shortStatus;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }
}
