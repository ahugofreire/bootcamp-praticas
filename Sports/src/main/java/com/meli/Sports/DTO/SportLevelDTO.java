package com.meli.Sports.DTO;

import com.meli.Sports.entity.Sport;

public class SportLevelDTO {
    private String level;

    public SportLevelDTO(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SportLevelDTO{" +
                "level='" + level + '\'' +
                '}';
    }
}
