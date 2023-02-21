package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "DischargeSummaries")
public class DischargeSummary {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "File",columnDefinition = "varchar(MAX)",nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Doctor_Id",columnDefinition = "varchar(36)",referencedColumnName = "Id",unique = true)
    private Doctor doctor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Patient_Id",columnDefinition = "varchar(36)",referencedColumnName = "Id",unique = true)
    private Patient patient;

    public DischargeSummary() {
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
