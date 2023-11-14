package com.example.demo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Leagues")
public class League {

    private String id;
    private String name;
    private String type;
    private String logo;


    public League(String id, String name, String type, String logo) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.logo = logo;
    }

    public League(String name, String type, String logo) {
        this.name = name;
        this.type = type;
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
