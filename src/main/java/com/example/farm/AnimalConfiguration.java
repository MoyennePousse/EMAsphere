package com.example.farm;

import com.example.farm.Repository.AnimalRepository;
import com.example.farm.model.Animal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AnimalConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerAnimal(AnimalRepository repository){
        return args -> {
            Animal pig = new Animal("Bob", "1234-ABC-9876", 4, 19.3);
            Animal cow = new Animal("Marguerite", "6473-PER-4724", 8, 639);

            repository.saveAll(
                    List.of(pig, cow)
            );
        };
    }
}
