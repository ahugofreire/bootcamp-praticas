package com.meli.dealership.service;

import com.meli.dealership.entity.Vehicle;
import com.meli.dealership.exceptions.ResourceNotFoundException;
import com.meli.dealership.repository.DealershipRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DealershipService {
    private final DealershipRepository dealershipRepository;

    public Vehicle save(Vehicle vehicle) {
        return dealershipRepository.save(vehicle);
    }

    public List<Vehicle> findAll(){
        return dealershipRepository.findAll();
    }

    public List<Vehicle> findPriceRange(BigDecimal lowerBound, BigDecimal upperBound){
        return dealershipRepository.findByPriceRange(lowerBound, upperBound);
    }

    public List<Vehicle> findByDateRange(LocalDate lowerBound, LocalDate upperBound) {
        return dealershipRepository.findAllByDateRange(lowerBound, upperBound);
    }

    public Vehicle findById(Integer id) {
        Optional<Vehicle> vehicleOptional = dealershipRepository.findById(id);
        return vehicleOptional.orElseThrow(() -> new ResourceNotFoundException(("Não foi encontrado veículo com o id especificado")));
    }
}
