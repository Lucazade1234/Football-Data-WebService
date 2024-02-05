package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Getter
@Setter
@Data
@Document(collection = "Squads")
public class Squad {
    @Id
    private int id;
    private int teamID;
    private ArrayList<SquadMember> squadMembers;
    private String teamName;

    public Squad() {
    }

    public Squad(ArrayList<SquadMember> squadMembers, String name) {
        this.squadMembers = squadMembers;
        this.teamName = name;
    }

    public Squad(int teamID, ArrayList<SquadMember> squadMembers, String name) {
        this.teamID = teamID;
        this.squadMembers = squadMembers;
        this.teamName = name;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (SquadMember squadMember : squadMembers) {
            result.append("Player name:").append(squadMember.getName()).append("||").append("player number:").append(squadMember.getNumber()).append("\\");
        }

        return result.toString();
    }

}

