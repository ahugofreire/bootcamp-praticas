package com.meli.Sports.DTO;

import com.meli.Sports.entity.Sport;

import java.util.concurrent.ThreadLocalRandom;

public class SportDTO {
    private String name;
    private String level;

    public SportDTO(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public SportDTO() {

    }

    public Sport convert() {
       Integer number = (Integer) ThreadLocalRandom.current().nextInt(1,199);
       return new Sport(number, this.name, this.level);
    }

    public SportDTO convert(Sport sport) {
        this.name = sport.getName();
        this.level = sport.getLevel();
        return this;
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

    @Override
    public String toString() {
        return "SportDTO{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
