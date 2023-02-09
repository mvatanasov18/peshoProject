package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Hospitals")
public class Hospital {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "Name",columnDefinition = "nvarchar(150)",nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressId",columnDefinition = "varchar(36)",referencedColumnName = "Id",unique = true)
    private Address address;

    public Hospital() {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
