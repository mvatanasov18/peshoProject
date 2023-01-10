package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Visits")
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @ManyToOne
    @JoinColumn(name = "PatientID")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "RelativeID")
    private Relative relative;
    @Column(name = "VisitTime")
    private Date visitTime;
}

