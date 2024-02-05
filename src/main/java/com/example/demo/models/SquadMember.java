package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SquadMember {
    private int id;
    private String name;
    private int age;
    private int number;
    private String position;
    private String photo;

    public SquadMember() {
    }

    public SquadMember(int id, String name, int age, int number, String position, String photo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.position = position;
        this.photo = photo;
    }

}
