package com.example.farm.Repository;

import com.example.farm.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.matriculate = ?1")
    Optional<Animal> findAnimalByMatriculate(String matriculate);

}
