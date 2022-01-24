package com.example.farm.controller;

import com.example.farm.model.Farmer;
import com.example.farm.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "farmer")
public class FarmerController {

    private final FarmerService farmerService;

    @Autowired
    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping
    public List<Farmer> getFarmers(){
        return farmerService.getFarmers();
    }

    @PostMapping
    public void addFarmer(@RequestBody Farmer farmer){
        farmerService.addNewFarmer(farmer);
    }
}
