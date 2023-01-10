package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;
    @Column(name = "Street")
    private String street;
    @Column(name = "HouseNumber")
    private Integer houseNumber;
}

