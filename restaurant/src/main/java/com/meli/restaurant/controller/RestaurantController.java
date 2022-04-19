package com.meli.restaurant.controller;

import com.meli.restaurant.entity.FoodPlate;
import com.meli.restaurant.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/plate/{name}")
    public ResponseEntity<?> findFoodPlateByName(@PathVariable String name) {
        Optional<FoodPlate> optionalFoodPlate = restaurantService.findPlateContainsName(name);

        if (optionalFoodPlate.isEmpty()) {
            System.out.println(optionalFoodPlate);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalFoodPlate.get());
    }
}
