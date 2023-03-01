package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;
import java.util.UUID;
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "Date_Of_Birth",columnDefinition = "date",nullable = false)
    private String dateOfBirth;
    @Column(name = "Condition",columnDefinition = "nvarchar(36)",nullable = false)
    private String condition;
    @Column(name = "Surgery_Required",columnDefinition = "bit",nullable = false)
    private Boolean surgeryRequired;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String date) {
        this.dateOfBirth = date;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getSurgeryRequired() {
        return surgeryRequired;
    }

    public void setSurgeryRequired(Boolean surgeryRequired) {
        this.surgeryRequired = surgeryRequired;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
