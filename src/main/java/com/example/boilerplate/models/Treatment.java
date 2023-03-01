package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "Treatments")
public class Treatment {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "Name",columnDefinition = "nvarchar(255)",nullable = false)
    private String name;
    @Column(name = "Time",columnDefinition = "datetime2(0)",nullable = false)
    private String time;
    @Column(name = "Description",columnDefinition = "nvarchar(MAX)",nullable = false)
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Patient_Id",columnDefinition = "varchar(36)",referencedColumnName = "Id")
    private Patient patient;

    @ManyToMany
    @JoinTable(name = "ReceptionistsTreatments"
            ,joinColumns = @JoinColumn(name = "Treatment_Id"),
            inverseJoinColumns = @JoinColumn(name = "Receptionist_Id"))
    private Set<Receptionist> receptionists;

    public Treatment() {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
