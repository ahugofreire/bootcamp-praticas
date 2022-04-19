package com.meli.Sports.entity;

import java.util.Optional;

public class Person {
    private Integer id;
    private String name;
    private String lastname;
    private Integer age;
    private Sport sport;

    public Person(Integer id, String name, String lastname, Integer age, Sport sport) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sport = sport;
    }

    public Person(){

    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Optional<Sport> sport) {
        this.sport = sport;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
