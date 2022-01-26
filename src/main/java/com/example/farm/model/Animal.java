package com.example.farm.model;

import com.example.farm.constant.Constant;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Animal {

    @Id
    @SequenceGenerator(
            name = "animal_sequence",
            sequenceName = "animal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "animal_sequence"
    )
    private Long id;
    private String name;
    private String matriculate;
    private int hungerMeter;
    private double weight;

    public Animal() {}

    public Animal(Long id, String name, String matriculate, int hungerMeter, double weight) {
        this.id = id;
        this.name = name;
        this.matriculate = matriculate;
        this.hungerMeter = hungerMeter;
        this.weight = weight;
    }

    public Animal(String name, String matriculate, int hungerMeter, double weight) {
        this.name = name;
        this.matriculate = matriculate;
        this.hungerMeter = hungerMeter;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public String getMatriculate() {
        return matriculate;
    }

    public void setMatriculate(String matriculate) {
        this.matriculate = matriculate;
    }

    public int getHungerMeter() {
        return hungerMeter;
    }

    public void setHungerMeter(int hungerMeter) {
        if(this.hungerMeter + hungerMeter > 10){
            throw new IllegalStateException("Animal already being feed");
        }
        else if(this.hungerMeter + hungerMeter < 0){
            throw new IllegalStateException("Animal is too tired to do a walk");
        }
        this.hungerMeter += hungerMeter;
    }

    public void moveAnimalToWalk() {
        setHungerMeter(-Constant.WALK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.getWeight(), getWeight()) == 0 && Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight());
    }
}
