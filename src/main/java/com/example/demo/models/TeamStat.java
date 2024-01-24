package com.example.demo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "TeamStats")
public class TeamStat {
    private String id;
    private LeagueInfo league;
    private TeamInfo team;
    private String form;
    private FixtureInfo fixtures;
    private GoalInfo goals;
    private BiggestInfo biggest;
    private CleanSheetInfo cleanSheet;
    private FailedToScoreInfo failedToScore;
    private PenaltyInfo penalty;
    private List<LineupInfo> lineups;
    private CardInfo cards;

    public TeamStat() {
    }

    public TeamStat(String id,
                    LeagueInfo league,
                    TeamInfo team,
                    String form,
                    FixtureInfo fixtures,
                    GoalInfo goals,
                    BiggestInfo biggest,
                    CleanSheetInfo cleanSheet,
                    FailedToScoreInfo failedToScore,
                    PenaltyInfo penalty,
                    List<LineupInfo> lineups,
                    CardInfo cards) {
        this.id = id;
        this.league = league;
        this.team = team;
        this.form = form;
        this.fixtures = fixtures;
        this.goals = goals;
        this.biggest = biggest;
        this.cleanSheet = cleanSheet;
        this.failedToScore = failedToScore;
        this.penalty = penalty;
        this.lineups = lineups;
        this.cards = cards;
    }

    @Data
    public static class LeagueInfo {
        private int id;
        private String name;
        private String country;
        private String logo;
        private String flag;
        private int season;

        public LeagueInfo(int id, String name, String country, String logo, String flag) {
            this.id = id;
            this.name = name;
            this.country = country;
            this.logo = logo;
            this.flag = flag;
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

    @Data
    public static class TeamInfo {
        private int id;
        private String name;
        private String logo;

        public TeamInfo(int id, String name, String logo) {
            this.id = id;
            this.name = name;
            this.logo = logo;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLogo() {
            return logo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }
    }

    @Data
    public static class FixtureInfo {
        private int home;
        private int away;
        private int total;

        public FixtureInfo(int home, int away) {
            this.home = home;
            this.away = away;
            this.setTotal(home + away);
        }

        public int getHome() {
            return home;
        }

        public int getAway() {
            return away;
        }

        public int getTotal() {
            return total;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public void setAway(int away) {
            this.away = away;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    @Data
    public static class GoalInfo {
        private int home;
        private int away;

        public GoalInfo(int home, int away) {
            this.home = home;
            this.away = away;
        }

        public int getHome() {
            return home;
        }

        public int getAway() {
            return away;
        }

        public void setHome(int home) {
            this.home = home;
        }

        public void setAway(int away) {
            this.away = away;
        }

    }

    @Data
    public static class MinuteInfo {
        private Integer total;
        private String percentage;
        private String minuteRange;

        public MinuteInfo(Integer total, String percentage, String minuteRange) {
            this.total = total;
            this.percentage = percentage;
            this.minuteRange = minuteRange;
        }

        public Integer getTotal() {
            return total;
        }

        public String getPercentage() {
            return percentage;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public void setPercentage(String percentage) {
            this.percentage = percentage;
        }

        public String getMinuteRange() {
            return minuteRange;
        }

        public void setMinuteRange(String minuteRange) {
            this.minuteRange = minuteRange;
        }
    }

    @Data
    public static class BiggestStreakInfo {
        private int wins;
        private int draws;
        private int loses;

        public BiggestStreakInfo(int wins, int draws, int loses) {
            this.wins = wins;
            this.draws = draws;
            this.loses = loses;
        }

        public int getWins() {
            return wins;
        }

        public int getDraws() {
            return draws;
        }

        public int getLoses() {
            return loses;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }

        public void setLoses(int loses) {
            this.loses = loses;
        }
    }

    @Data
    public static class BiggestInfo {
        private BiggestStreakInfo streak;
        private String home;
        private String away;
        private GoalInfo goals;

        public BiggestInfo(BiggestStreakInfo streak, String home, String away, GoalInfo goals) {
            this.streak = streak;
            this.home = home;
            this.away = away;
            this.goals = goals;
        }

        public BiggestStreakInfo getStreak() {
            return streak;
        }

        public void setStreak(BiggestStreakInfo streak) {
            this.streak = streak;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getAway() {
            return away;
        }

        public void setAway(String away) {
            this.away = away;
        }

        public GoalInfo getGoals() {
            return goals;
        }

        public void setGoals(GoalInfo goals) {
            this.goals = goals;
        }
    }

    @Data
    public static class CleanSheetInfo {
        private int home;
        private int away;
        private int total;


        public CleanSheetInfo(int home, int away) {
            this.home = home;
            this.away = away;
            this.total = home + away;
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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    @Data
    public static class FailedToScoreInfo {
        private int home;
        private int away;
        private int total;

        public FailedToScoreInfo(int home, int away) {
            this.home = home;
            this.away = away;
            this.total = home + away;
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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    @Data
    public static class PenaltyInfo {
        private int total;
        private int scored;
        private int missed;
        private String percentageScored;
        private String percentageMissed;

        public PenaltyInfo(int scored, int missed, String percentageScored, String percentageMissed) {
            this.scored = scored;
            this.missed = missed;
            this.percentageScored = percentageScored;
            this.percentageMissed = percentageMissed;

        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPercentageScored() {
            return percentageScored;
        }

        public void setPercentageScored(String percentageScored) {
            this.percentageScored = percentageScored;
        }
    }

    @Data
    public static class LineupInfo {
        private String formation;
        private int played;

        public LineupInfo(String formation, int played) {
            this.formation = formation;
            this.played = played;
        }

        public String getFormation() {
            return formation;
        }

        public void setFormation(String formation) {
            this.formation = formation;
        }

        public int getPlayed() {
            return played;
        }

        public void setPlayed(int played) {
            this.played = played;
        }
    }

    @Data
    public static class CardInfo {
        private List<MinuteInfo> yellow;
        private List<MinuteInfo> red;

        public CardInfo(List<MinuteInfo> yellow, List<MinuteInfo> red) {
            this.yellow = yellow;
            this.red = red;
        }

        public List<MinuteInfo> getYellow() {
            return yellow;
        }

        public void setYellow(List<MinuteInfo> yellow) {
            this.yellow = yellow;
        }

        public List<MinuteInfo> getRed() {
            return red;
        }

        public void setRed(List<MinuteInfo> red) {
            this.red = red;
        }

        public int getYellowTotal(){
            int totalCards = 0;
            for(MinuteInfo yellowstat : this.yellow){
                if(yellowstat.total > 0) {
                    totalCards = totalCards + yellowstat.total;
                }
            }
            return totalCards;
        }

        public int getRedTotal(){
            int totalCards = 0;
            for(MinuteInfo redstat : this.red){
                if(redstat.total > 0) {
                    totalCards = totalCards + redstat.total;
                }
            }
            return totalCards;
        }
    }
}
