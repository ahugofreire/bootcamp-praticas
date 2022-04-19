package com.meli.Sports.repository;

import com.meli.Sports.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private static final List<Person> persons = new ArrayList<Person>();

    public void save(Person person) {
        persons.add(person);
    }

    public List<Person> findAll() {
        return persons;
    }
}
