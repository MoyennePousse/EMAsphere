package com.example.farm.service;

import com.example.farm.Repository.FarmerRepository;
import com.example.farm.model.Farmer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public List<Farmer> getFarmers(){
        return farmerRepository.findAll();
    }
}
