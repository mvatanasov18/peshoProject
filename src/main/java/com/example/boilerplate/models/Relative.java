package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Relatives")
public class Relative {
    @Id
    @Column(name = "User_Id",columnDefinition = "varchar(36)",nullable = false)
private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Address_Id",columnDefinition = "varchar(36)",referencedColumnName ="Id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    public Relative() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
