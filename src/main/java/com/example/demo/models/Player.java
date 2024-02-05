package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Players")
public class Player {
    @Id
    private String id;
    private int playerID;
    private String firstname;
    private String lastname;
    private int age;
    private String dob;
    private String placeOfBirth;
    private String nationality;
    private String height;
    private String weight;
    private boolean injured;
    private String photo;
    private PlayerStat playerStats;

    public Player() {
    }

    public Player(String id,
                  int playerID,
                  String firstname,
                  String lastname,
                  int age,
                  String dob,
                  String placeOfBirth,
                  String nationality,
                  String height,
                  String weight,
                  boolean injured,
                  String photo,
                  PlayerStat playerStats) {

        this.id = id;
        this.playerID = playerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.dob = dob;
        this.placeOfBirth = placeOfBirth;
        this.nationality = nationality;
        this.height = height;
        this.weight = weight;
        this.injured = injured;
        this.photo = photo;
        this.playerStats = playerStats;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public boolean isInjured() {
        return injured;
    }

    public void setInjured(boolean injured) {
        this.injured = injured;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

