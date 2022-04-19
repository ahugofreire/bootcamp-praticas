package com.meli.Sports.repository;

import com.meli.Sports.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SportRepository {
    private static final List<Sport> sports = new ArrayList<Sport>();

    public Optional<Sport> findBy(Sport name) {
        return sports.stream().filter(sport -> sport.compareTo(name)).findFirst();
    }

    public void save(Sport  sport) {
        sports.add(sport);
    }

    public List<Sport> findAll() {
        return sports;
    }
}
