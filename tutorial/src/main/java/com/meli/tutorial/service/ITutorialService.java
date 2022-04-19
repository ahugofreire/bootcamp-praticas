package com.meli.tutorial.service;

import com.meli.tutorial.entity.Tutorial;

import java.util.List;

public interface ITutorialService {
    Tutorial create(Tutorial tutorial);
    List<Tutorial> find();
    Tutorial findOne(Long id);
    Tutorial update(Long id, Tutorial tutorial);
    void remove(Long id);
    void removeAll(List<Long> ids);
    List<Tutorial> findByPublished();
    List<Tutorial> findByTitle(String title);
}
