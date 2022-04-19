package com.meli.Sports.DTO;

import com.meli.Sports.entity.Person;
import com.meli.Sports.entity.Sport;
import com.meli.Sports.service.SportService;

import java.util.concurrent.ThreadLocalRandom;

public class PersonDTO {
    private Integer number;
    private String name;
    private String lastname;
    private Integer age;
    private String sportName;

    public PersonDTO(Integer number, String name, String lastname, Integer age, String sportName) {

        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.sportName = sportName;
    }

    public Person convert(){
        Integer number = (Integer) ThreadLocalRandom.current().nextInt(1,199);

        return new PersonDTO(this.number, this.name, this.lastname, this.age, this.sportName);

    }

    public PersonDTO convert(Person person) {
        this.name = person.getName();
        this.lastname = person.getLastname();
        this.age = person.getAge();
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
