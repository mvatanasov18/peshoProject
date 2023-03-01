package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @Column(name = "Id",nullable = false,columnDefinition = "varchar(36)")
    private String id;
    @Column(name = "Specialization",nullable = false,columnDefinition = "nvarchar(70)")
    private String specialization;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id",unique = true,columnDefinition ="varchar(36)",referencedColumnName ="Id")
    private User User;

    public Doctor(){

        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public com.example.boilerplate.models.User getUser() {
        return User;
    }

    public void setUser(com.example.boilerplate.models.User user) {
        User = user;
    }
}
