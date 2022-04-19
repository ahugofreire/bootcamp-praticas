package com.meli.Sports.entity;

public class Sport {
    private  Integer id;
    private String name;
    private String level;

    public Sport(Integer id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean compareTo(String name) {
        return this.name.equalsIgnoreCase(name);
    }
}
