package com.meli.dealership.repository;

import com.meli.dealership.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DealershipRepository {
    private final List<Vehicle> vehicles;

    public DealershipRepository(){
        this.vehicles = new LinkedList<>();
    }

    public Vehicle save(Vehicle vehicle){
        vehicle.setId(vehicles.size() -1);
        vehicles.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> findAll() {
        return vehicles;
    }

    public Optional<Vehicle> findById(Integer id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId().equals(id)).findFirst();
    }

    public List<Vehicle> findByPriceRange(BigDecimal lowerBound, BigDecimal upperBound) {
        return vehicles.stream().filter(vehicle -> {
            BigDecimal price = vehicle.getPrice();
            return price.compareTo(lowerBound) >= 0 && price.compareTo(upperBound) <= 0;
        }).collect(Collectors.toList());
    }

    public List<Vehicle> findAllByDateRange(LocalDate lowerBound, LocalDate upperBound) {
        return vehicles.stream().filter(vehicle -> {
            LocalDate manufacturingDate = vehicle.getManufacturingDate();
            return manufacturingDate.compareTo(lowerBound) >= 0 && manufacturingDate.compareTo(upperBound) <= 0;
        }).collect(Collectors.toList());
    }
}
