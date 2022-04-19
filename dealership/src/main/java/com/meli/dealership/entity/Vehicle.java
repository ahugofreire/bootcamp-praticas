package com.meli.dealership.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
    private Integer id;
    private String brand;
    private  String model;
    private LocalDate manufacturingDate;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<Services> services;
    private int countOfOwners;
}
