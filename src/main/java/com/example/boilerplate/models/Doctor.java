package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Doctors")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "Specialization")
    private String specialization;
    @Column(name = "Email",unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}


