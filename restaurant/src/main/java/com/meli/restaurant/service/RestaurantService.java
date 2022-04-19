package com.meli.restaurant.service;

import com.meli.restaurant.entity.FoodPlate;
import com.meli.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public Optional<FoodPlate> findPlateContainsName(String name) {
        return restaurantRepository.findByName(name);
    }
}
