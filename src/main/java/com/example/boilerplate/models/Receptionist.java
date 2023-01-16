package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Receptionists")
@Data
public class Receptionist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name="Email" , unique = true)
    private String email;
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}

