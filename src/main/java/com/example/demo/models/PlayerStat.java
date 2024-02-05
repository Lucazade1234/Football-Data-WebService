package com.example.demo.models;

public class PlayerStat {
    private Team team;
    private League league;
    private Games games;
    private Substitutes substitutes;
    private Shots shots;
    private Goals goals;
    private Passes passes;
    private Tackles tackles;
    private Duels duels;
    private Dribbles dribbles;
    private Fouls fouls;
    private Cards cards;
    private Penalty penalty;

    public PlayerStat() {
    }

    public PlayerStat(Team team,
                      League league,
                      Games games,
                      Substitutes substitutes,
                      Shots shots,
                      Goals goals,
                      Passes passes,
                      Tackles tackles,
                      Duels duels,
                      Dribbles dribbles,
                      Fouls fouls,
                      Cards cards,
                      Penalty penalty) {
        this.team = team;
        this.league = league;
        this.games = games;
        this.substitutes = substitutes;
        this.shots = shots;
        this.goals = goals;
        this.passes = passes;
        this.tackles = tackles;
        this.duels = duels;
        this.dribbles = dribbles;
        this.fouls = fouls;
        this.cards = cards;
        this.penalty = penalty;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public Games getGames() {
        return games;
    }

    public void setGames(Games games) {
        this.games = games;
    }

    public Substitutes getSubstitutes() {
        return substitutes;
    }

    public void setSubstitutes(Substitutes substitutes) {
        this.substitutes = substitutes;
    }

    public Shots getShots() {
        return shots;
    }

    public void setShots(Shots shots) {
        this.shots = shots;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public Passes getPasses() {
        return passes;
    }

    public void setPasses(Passes passes) {
        this.passes = passes;
    }

    public Tackles getTackles() {
        return tackles;
    }

    public void setTackles(Tackles tackles) {
        this.tackles = tackles;
    }

    public Duels getDuels() {
        return duels;
    }

    public void setDuels(Duels duels) {
        this.duels = duels;
    }

    public Dribbles getDribbles() {
        return dribbles;
    }

    public void setDribbles(Dribbles dribbles) {
        this.dribbles = dribbles;
    }

    public Fouls getFouls() {
        return fouls;
    }

    public void setFouls(Fouls fouls) {
        this.fouls = fouls;
    }

    public Cards getCards() {
        return cards;
    }

    public void setCards(Cards cards) {
        this.cards = cards;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    // Nested classes for better organization

    public static class Team {
        private int id;
        private String name;
        private String logo;

        public Team(int id, String name, String logo) {
            this.id = id;
            this.name = name;
            this.logo = logo;
        }

        public Team() {
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

    }

    public static class League {
        private int id;
        private String name;
        private String country;
        private String logo;
        private String flag;
        private int season;

        public League() {
        }

        public League(int id, String name, String country, String logo, String flag, int season) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.logo = logo;
            this.flag = flag;
            this.season = season;
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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public int getSeason() {
            return season;
        }

        public void setSeason(int season) {
            this.season = season;
        }
    }

    public static class Games {
        private int appearances;
        private int lineups;
        private int minutes;
        private String position;
        private String rating;
        private boolean captain;

        public Games() {
        }

        public Games(int appearances,
                     int lineups,
                     int minutes,
                     String position,
                     String rating,
                     boolean captain) {
            this.appearances = appearances;
            this.lineups = lineups;
            this.minutes = minutes;
            this.position = position;
            this.rating = rating;
            this.captain = captain;
        }

        public int getAppearances() {
            return appearances;
        }

        public void setAppearances(int appearances) {
            this.appearances = appearances;
        }

        public int getLineups() {
            return lineups;
        }

        public void setLineups(int lineups) {
            this.lineups = lineups;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }




        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public boolean isCaptain() {
            return captain;
        }

        public void setCaptain(boolean captain) {
            this.captain = captain;
        }

    }

    public static class Substitutes {
        private int in;
        private int out;
        private int bench;

        public Substitutes() {
        }

        public Substitutes(int in, int out, int bench) {
            this.in = in;
            this.out = out;
            this.bench = bench;
        }

        public int getIn() {
            return in;
        }

        public void setIn(int in) {
            this.in = in;
        }

        public int getOut() {
            return out;
        }

        public void setOut(int out) {
            this.out = out;
        }

        public int getBench() {
            return bench;
        }

        public void setBench(int bench) {
            this.bench = bench;
        }

    }

    public static class Shots {
        private Integer total;
        private Integer on;

        private Integer off;

        public Shots() {
        }

        public Shots(Integer total, Integer on) {
            this.total = total;
            this.on = on;
            this.off = total - on;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getOn() {
            return on;
        }

        public void setOn(Integer on) {
            this.on = on;
        }

    }

    public static class Goals {
        private int total;
        private Integer conceded;
        private Integer assists;
        private Integer saves;

        public Goals() {
        }

        public Goals(int total, Integer conceded, Integer assists, Integer saves) {
            this.total = total;
            this.conceded = conceded;
            this.assists = assists;
            this.saves = saves;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Integer getConceded() {
            return conceded;
        }

        public void setConceded(Integer conceded) {
            this.conceded = conceded;
        }

        public Integer getAssists() {
            return assists;
        }

        public void setAssists(Integer assists) {
            this.assists = assists;
        }

        public Integer getSaves() {
            return saves;
        }

        public void setSaves(Integer saves) {
            this.saves = saves;
        }

    }

    public static class Passes {
        private Integer total;
        private Integer key;
        private Integer accuracy;

        public Passes() {
        }

        public Passes(Integer total, Integer key, Integer accuracy) {
            this.total = total;
            this.key = key;
            this.accuracy = accuracy;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(Integer accuracy) {
            this.accuracy = accuracy;
        }

    }

    public static class Tackles {
        private Integer total;
        private Integer blocks;
        private Integer interceptions;

        public Tackles() {
        }

        public Tackles(Integer total, Integer blocks, Integer interceptions) {
            this.total = total;
            this.blocks = blocks;
            this.interceptions = interceptions;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getBlocks() {
            return blocks;
        }

        public void setBlocks(Integer blocks) {
            this.blocks = blocks;
        }

        public Integer getInterceptions() {
            return interceptions;
        }

        public void setInterceptions(Integer interceptions) {
            this.interceptions = interceptions;
        }

    }

    public static class Duels {
        private Integer total;
        private Integer won;

        public Duels() {
        }

        public Duels(Integer total, Integer won) {
            this.total = total;
            this.won = won;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getWon() {
            return won;
        }

        public void setWon(Integer won) {
            this.won = won;
        }

    }

    public static class Dribbles {
        private Integer attempts;
        private Integer success;
        private Integer past;

        public Dribbles() {
        }

        public Dribbles(Integer attempts, Integer success, Integer past) {
            this.attempts = attempts;
            this.success = success;
            this.past = past;
        }

        public Integer getAttempts() {
            return attempts;
        }

        public void setAttempts(Integer attempts) {
            this.attempts = attempts;
        }

        public Integer getSuccess() {
            return success;
        }

        public void setSuccess(Integer success) {
            this.success = success;
        }

        public Integer getPast() {
            return past;
        }

        public void setPast(Integer past) {
            this.past = past;
        }

    }

    public static class Fouls {
        private Integer drawn;
        private Integer committed;

        public Fouls() {
        }

        public Fouls(Integer drawn, Integer committed) {
            this.drawn = drawn;
            this.committed = committed;
        }

        public Integer getDrawn() {
            return drawn;
        }

        public void setDrawn(Integer drawn) {
            this.drawn = drawn;
        }

        public Integer getCommitted() {
            return committed;
        }

        public void setCommitted(Integer committed) {
            this.committed = committed;
        }

    }

    public static class Cards {
        private int yellow;
        private int yellowred;
        private int red;

        public Cards() {
        }

        public Cards(int yellow, int yellowred, int red) {
            this.yellow = yellow;
            this.yellowred = yellowred;
            this.red = red;
        }

        public int getYellow() {
            return yellow;
        }

        public void setYellow(int yellow) {
            this.yellow = yellow;
        }

        public int getYellowred() {
            return yellowred;
        }

        public void setYellowred(int yellowred) {
            this.yellowred = yellowred;
        }

        public int getRed() {
            return red;
        }

        public void setRed(int red) {
            this.red = red;
        }

    }

    public static class Penalty {
        private Integer won;
        private Integer commited;
        private Integer scored;
        private Integer missed;
        private Integer saved;

        public Penalty() {
        }

        public Penalty(Integer won, Integer commited, Integer scored, Integer missed, Integer saved) {
            this.won = won;
            this.commited = commited;
            this.scored = scored;
            this.missed = missed;
            this.saved = saved;
        }

        public Integer getWon() {
            return won;
        }

        public void setWon(Integer won) {
            this.won = won;
        }

        public Integer getCommited() {
            return commited;
        }

        public void setCommited(Integer commited) {
            this.commited = commited;
        }

        public Integer getScored() {
            return scored;
        }

        public void setScored(Integer scored) {
            this.scored = scored;
        }

        public Integer getMissed() {
            return missed;
        }

        public void setMissed(Integer missed) {
            this.missed = missed;
        }

        public Integer getSaved() {
            return saved;
        }

        public void setSaved(Integer saved) {
            this.saved = saved;
        }

    }
}

