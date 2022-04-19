package com.meli.Sports.service;

import com.meli.Sports.entity.Sport;
import com.meli.Sports.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public void createSport(Sport sport) {
        sportRepository.save(sport);
    }

    public Optional<Sport> findByName(String name) {
        return sportRepository.findBy(name);
    }

    public List<Sport> findAll() {
        return sportRepository.findAll();
    }
}
