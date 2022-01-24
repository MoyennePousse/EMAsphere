package com.example.farm.controller;

import com.example.farm.model.Animal;
import com.example.farm.model.Farmer;
import com.example.farm.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping
    public List<Animal> getAnimal() {
        return animalService.getAnimals();
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        animalService.addNewAnimal(animal);
    }
}
