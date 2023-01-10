package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "DateOfBirth")
    private Date dateOfBirth;
    @Column(name = "Condition")
    private String condition;
    @Column(name = "Medicaments")
    private String medicament;
    @Column(name = "SurgeryRequired")
    private boolean surgeryRequired;
    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;
}

