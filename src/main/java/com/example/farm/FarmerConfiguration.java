package com.example.farm;

import com.example.farm.Repository.FarmerRepository;
import com.example.farm.model.Farmer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class FarmerConfiguration {

    @Bean
    CommandLineRunner commandLineRunnerFarmer(FarmerRepository repository){
        return args -> {
            Farmer farmer1 = new Farmer("Patrick", "Martin", LocalDate.of(1978, Month.FEBRUARY, 22));
            Farmer farmer2 = new Farmer("Roger", "Dupré", LocalDate.of(1981, Month.DECEMBER, 03));

            repository.saveAll(
                    List.of(farmer1, farmer2)
            );
        };
    }
}
