package com.meli.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class FoodPlate {
    private String name;
    private Integer calories;
}
