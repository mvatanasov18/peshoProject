package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Relatives")
@Data
public class Relative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Phone",length = 12)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "AddressID")
    private Address address;
}

