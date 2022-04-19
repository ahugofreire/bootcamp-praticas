package com.meli.restaurant.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.restaurant.entity.FoodPlate;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class RestaurantRepository {
    private final List<FoodPlate> foodPlates;
    private final ObjectMapper mapper;
    private static final String PLATES = "src/main/resources/food.json";

    public RestaurantRepository(ObjectMapper mapper){
        this.mapper = mapper;
        this.foodPlates = new ArrayList<>();
        System.out.println(PLATES);
        getAllPlates();
    }

    public void getAllPlates(){
        try {
            TypeReference<List<FoodPlate>> listTypeReference = new TypeReference<>() {};
            List<FoodPlate> plates = mapper.readValue(Paths.get(PLATES).toFile(), listTypeReference);
            foodPlates.addAll(plates);
            System.out.println(plates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Optional<FoodPlate> findByName(String name) {

        return this.foodPlates.stream().filter(plate -> plate.getName()
                .toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).findFirst();
    }

    public void addNewPlate(){

    }
}
