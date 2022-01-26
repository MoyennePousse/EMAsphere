package com.example.farm.service;

import com.example.farm.Repository.AnimalRepository;
import com.example.farm.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAnimals(){
        return animalRepository.findAll();
    }

    public void addNewAnimal(Animal animal) {
        Optional<Animal> animalByMat = animalRepository.findAnimalByMatriculate(animal.getMatriculate());
        if(animalByMat.isPresent()){
            throw new IllegalStateException("Matriculate should be unique");
        }
        animalRepository.save(animal);
    }

    public void moveAnimalToWalk(Long idAnimal){
        Optional<Animal> animalById = animalRepository.findById(idAnimal);
        if(!animalById.isPresent()){
            throw new IllegalStateException("Animal is not present");
        }
        animalById.get().moveAnimalToWalk();
        animalRepository.save(animalById.get());
    }
}
