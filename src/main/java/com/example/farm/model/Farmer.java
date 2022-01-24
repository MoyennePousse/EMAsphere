package com.example.farm.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Farmer {

    @Id
    @SequenceGenerator(
            name = "farmer_sequence",
            sequenceName = "farmer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "farmer_sequence"
    )
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;

    public Farmer(){}

    public Farmer(Long id, String firstname, String lastname, LocalDate birthdate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public Farmer(String firstname, String lastname, LocalDate birthdate){
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Farmer)) return false;
        Farmer farmer = (Farmer) o;
        return Objects.equals(getFirstname(), farmer.getFirstname()) && Objects.equals(getLastname(), farmer.getLastname()) && Objects.equals(getBirthdate(), farmer.getBirthdate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstname(), getLastname(), getBirthdate());
    }
}
