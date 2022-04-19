package com.meli.tutorial.controller;

import com.meli.tutorial.entity.Tutorial;
import com.meli.tutorial.service.ITutorialService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {
    @Autowired
    private final ITutorialService tutorialService;

    @PostMapping()
    public ResponseEntity<Tutorial> createTutorial(@RequestBody @Valid Tutorial tutorial) {
        Tutorial tutorialCreated = this.tutorialService.create(tutorial);

        return ResponseEntity.created(URI.create("/api/tutorials/" + tutorialCreated.getId())).body(tutorialCreated);
    }

    @GetMapping()
    public ResponseEntity<List<Tutorial>> findAll(@RequestParam(required = false) String title) {
        if (title == null) {
            return ResponseEntity.ok().body(this.tutorialService.find());
        }

        return ResponseEntity.ok().body(this.tutorialService.findByTitle(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.tutorialService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateById(@PathVariable Long id, @RequestBody Tutorial tutorial) {
        return ResponseEntity.ok().body(this.tutorialService.update(id, tutorial));
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteAllByIds(@RequestBody List<Long> ids) {
        this.tutorialService.removeAll(ids);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAllByIds(@PathVariable Long id) {
        this.tutorialService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> findTutorialByIsPublished() {
        return ResponseEntity.ok().body(this.tutorialService.findByPublished());
    }
}
