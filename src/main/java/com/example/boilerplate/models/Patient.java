package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "Date_Of_Birth",columnDefinition = "date",nullable = false)
    private String date;
    @Column(name = "Condition",columnDefinition = "nvarchar(36)",nullable = false)
    private String condition;
    @Column(name = "Surgery_Required",columnDefinition = "bit",nullable = false)
    private String surgeryRequired;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_Id",columnDefinition = "varchar(36)", unique = true, referencedColumnName = "Id")
    private User user;

    @ManyToMany
    @JoinTable(name = "PatientsMedicines"
            ,joinColumns = @JoinColumn(name = "Patient_Id"),
            inverseJoinColumns = @JoinColumn(name = "Medicine_Id"))
    private Set<Medicine> medicines;

    public Patient() {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSurgeryRequired() {
        return surgeryRequired;
    }

    public void setSurgeryRequired(String surgeryRequired) {
        this.surgeryRequired = surgeryRequired;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
