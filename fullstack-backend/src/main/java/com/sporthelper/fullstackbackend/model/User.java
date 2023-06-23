package com.sporthelper.fullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue()
    @JsonProperty("id")
    private Long id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("main_sport")
    private String main_sport;
    @JsonProperty("introduction")
    private String introduction;
    @JsonProperty("age")
    private int age;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone_number")
    private String phone_number;
    @JsonProperty("password")
    private String password;
    @JsonProperty("user_name")
    private String user_name;

    @JsonProperty("liked_players")
    private String liked_players;

    public String getLiked_players() {
        return liked_players;
    }

    public void setLiked_players(String liked_players) {
        this.liked_players = liked_players;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("location")
    private String location;
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getMain_sport() {
        return main_sport;
    }
    public void setMain_sport(String main_sport) {
        this.main_sport = main_sport;
    }
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
