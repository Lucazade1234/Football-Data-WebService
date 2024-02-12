package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Venue {
    private int id;
    private String name;
    private String city;

    public Venue() {
    }

    public Venue(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
