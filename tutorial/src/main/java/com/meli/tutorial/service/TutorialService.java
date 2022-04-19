package com.meli.tutorial.service;

import com.meli.tutorial.entity.Tutorial;
import com.meli.tutorial.repository.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TutorialService implements ITutorialService{

    @Autowired
    private final TutorialRepository tutorialRepository;

    @Override
    public Tutorial create(Tutorial tutorial) {
        return this.tutorialRepository.save(tutorial);
    }

    @Override
    public List<Tutorial> find() {
        return this.tutorialRepository.findAll();
    }

    @Override
    public Tutorial findOne(Long id) {
        return this.tutorialRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Tutorial update(Long id, Tutorial tutorial) {
        Tutorial existTutorial = tutorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Does not exits tutorial"));

        existTutorial.setTitle(tutorial.getTitle());
        existTutorial.setDescription(tutorial.getDescription());
        existTutorial.setPublished(tutorial.getPublished());

        return tutorialRepository.save(existTutorial);
    }

    @Override
    public void remove(Long id) {
        this.tutorialRepository.deleteById(id);
    }

    @Override
    public void removeAll(List<Long> ids) {
        this.tutorialRepository.deleteAllById(ids);
    }

    @Override
    public List<Tutorial> findByPublished() {
        return this.tutorialRepository.findAll().stream().filter(Tutorial::getPublished).collect(Collectors.toList());
    }

    @Override
    public List<Tutorial> findByTitle( String title) {
//        return this.tutorialRepository.findAll().stream().filter(t -> t.getTitle().contains(title)).collect(Collectors.toList());
        return  this.tutorialRepository.findByTitleLike(title);
    }
}
