package com.meli.Sports.service;

import com.meli.Sports.DTO.PersonDTO;
import com.meli.Sports.entity.Person;
import com.meli.Sports.entity.Sport;
import com.meli.Sports.repository.PersonRepository;
import com.meli.Sports.repository.SportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private ModelMapper mapper;

    public void CreatePerson(PersonDTO personDTO) {
        Person entity = mapper.map(personDTO, Person.class);
        Optional<Sport> sports = sportRepository.findBy(personDTO.getSport());
        entity.setSport(sports);

        personRepository.save(entity);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
