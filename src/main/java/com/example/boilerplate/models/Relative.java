package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Relatives")
public class Relative {
    @Id
    @Column(name = "UserId",columnDefinition = "varchar(36)",nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private User id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AddressId",columnDefinition = "varchar(36)",referencedColumnName ="Id")
    private Address address;

    public Relative() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
