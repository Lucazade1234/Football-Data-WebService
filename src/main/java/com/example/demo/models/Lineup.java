package com.example.demo.models;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@Data
@Document(collection = "Lineups")
public class Lineup {
    @Id
    private String id;
    private int fixtureId;
    private LineupTeam lineupTeam;
    private LineupCoach lineupCoach;
    private String formation;
    private List<LineupPlayer> startXI;
    private List<LineupPlayer> substitutes;

    public Lineup(int fixtureId, LineupTeam lineupTeam, LineupCoach lineupCoach, String formation, List<LineupPlayer> startXI, List<LineupPlayer> substitutes) {
        this.fixtureId = fixtureId;
        this.lineupTeam = lineupTeam;
        this.lineupCoach = lineupCoach;
        this.formation = formation;
        this.startXI = startXI;
        this.substitutes = substitutes;
    }

    @Setter
    @Getter
    public static class LineupTeam {
        private int id;
        private String name;
        private String logo;
        private Colors colors;

        public LineupTeam() {
        }

        public LineupTeam(int id, String name, String logo, Colors colors) {
            this.id = id;
            this.name = name;
            this.logo = logo;
            this.colors = colors;
        }

    }

    @Getter
    @Setter
    public static class Colors {
        private Color player;
        private Color goalkeeper;

        public Colors() {
        }

        public Colors(Color player, Color goalkeeper) {
            this.player = player;
            this.goalkeeper = goalkeeper;
        }
    }

    @Getter
    @Setter
    public static class Color {
        private String primary;
        private String number;
        private String border;

        public Color() {
        }

        public Color(String primary, String number, String border) {
            this.primary = primary;
            this.number = number;
            this.border = border;
        }
    }

    @Getter
    @Setter
    public static class LineupCoach {
        private int id;
        private String name;
        private String photo;

        public LineupCoach() {
        }

        public LineupCoach(int id, String name, String photo) {
            this.id = id;
            this.name = name;
            this.photo = photo;
        }
    }

    @Getter
    @Setter
    public static class LineupPlayer {
        private LineupPlayerDetails player;

        public LineupPlayer() {
        }

        public LineupPlayer(LineupPlayerDetails player) {
            this.player = player;
        }
    }


    @Getter
    @Setter
    public static class LineupPlayerDetails {
        private int id;
        private String name;
        private int number;
        private String pos;
        private String grid;

        public LineupPlayerDetails() {
        }

        public LineupPlayerDetails(int id, String name, int number, String pos, String grid) {
            this.id = id;
            this.name = name;
            this.number = number;
            this.pos = pos;
            this.grid = grid;
        }
    }
}

