package com.example.demo.models;

public class Score {
    private HalfTime halftime;
    private FullTime fulltime;
    private ExtraTime extratime;
    private Penalty penalty;

    public Score(HalfTime halftime, FullTime fulltime, ExtraTime extratime, Penalty penalty) {
        this.halftime = halftime;
        this.fulltime = fulltime;
        this.extratime = extratime;
        this.penalty = penalty;
    }

    public Score() {
    }

    public HalfTime getHalftime() {
        return halftime;
    }

    public void setHalftime(HalfTime halftime) {
        this.halftime = halftime;
    }

    public FullTime getFulltime() {
        return fulltime;
    }

    public void setFulltime(FullTime fulltime) {
        this.fulltime = fulltime;
    }

    public ExtraTime getExtratime() {
        return extratime;
    }

    public void setExtratime(ExtraTime extratime) {
        this.extratime = extratime;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }
}
