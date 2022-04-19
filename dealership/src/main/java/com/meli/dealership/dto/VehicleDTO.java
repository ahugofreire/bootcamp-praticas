package com.meli.dealership.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class VehicleDTO {
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int doors;
    private BigDecimal price;
    private String currency;
    private List<ServicesDTO> services;
    private int countOfOwners;
}
