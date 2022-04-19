package com.meli.dealership.controller;

import com.meli.dealership.dto.VehicleDTO;
import com.meli.dealership.entity.Vehicle;
import com.meli.dealership.service.DealershipService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/veiculos")
@AllArgsConstructor
public class DealershipController {

    private final DealershipService dealershipService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(dealershipService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody VehicleDTO vehicleDTO){
        Vehicle vehicle = modelMapper.map(vehicleDTO, Vehicle.class);
        Vehicle savedVehicle = dealershipService.save(vehicle);

        URI location = URI.create("/v1/api/veiculos" + savedVehicle.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Vehicle vehicle = dealershipService.findById(id);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> findAllByPriceRange(@RequestParam("since") BigDecimal lowerBound, @RequestParam("to") BigDecimal upperBound) {
        List<Vehicle> vehicleList = dealershipService.findPriceRange(lowerBound, upperBound);
        return ResponseEntity.ok(vehicleList);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> findAllByDateRange(@RequestParam("since") LocalDate lowerBound, @RequestParam("to") LocalDate upperBound) {
        List<Vehicle> vehicleDateRange = dealershipService.findByDateRange(lowerBound, upperBound);
        return ResponseEntity.ok(vehicleDateRange);
    }
}
