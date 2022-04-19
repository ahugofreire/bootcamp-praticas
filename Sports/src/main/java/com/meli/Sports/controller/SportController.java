package com.meli.Sports.controller;

import com.meli.Sports.DTO.PersonDTO;
import com.meli.Sports.DTO.SportDTO;
import com.meli.Sports.DTO.SportLevelDTO;
import com.meli.Sports.entity.Person;
import com.meli.Sports.entity.Sport;
import com.meli.Sports.service.PersonService;
import com.meli.Sports.service.SportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class SportController {
    private final SportService sportService;
    private final PersonService personService;

    public SportController(SportService sportService, PersonService personService) {
        this.sportService = sportService;
        this.personService = personService;
    }

    @GetMapping("/sports")
    public ResponseEntity<?> findSpots() {
        return ResponseEntity.ok(sportService.findAll());
    }

    @PostMapping("/sports")
    public ResponseEntity<?> createSport(@RequestBody SportDTO sportDTO, UriComponentsBuilder uriBuilder) {
        Sport sport = sportDTO.convert();
        sportService.createSport(sport);

        URI uri = uriBuilder.path("/sports/{id}").buildAndExpand(sport.getId()).toUri();

        SportDTO sportCreated = sportDTO.convert(sport);

        return ResponseEntity.created(uri).body(sportCreated);
    }

    @GetMapping("/sports/{name}")
    public ResponseEntity<?> findSportByName(@PathVariable String name) {
        Optional<Sport> sport = sportService.findByName(name);

        if (sport.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        SportLevelDTO sportLevel = new SportLevelDTO(sport.get().getLevel());

        return ResponseEntity.ok(sportLevel);
    }

    @PostMapping("/people")
    public ResponseEntity<?> createPerson(@RequestBody PersonDTO personDTO,UriComponentsBuilder uriBuilder  ) {
        Person person = personDTO.convert();

        personService.CreatePerson(person);


        URI uri = uriBuilder.path("/people/{id}").buildAndExpand(person.getId()).toUri();

        PersonDTO personCreated = personDTO.convert(person);

        return ResponseEntity.created(uri).body(personCreated);
    }
}
