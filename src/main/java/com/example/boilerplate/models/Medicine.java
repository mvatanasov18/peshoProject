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
@Table(name = "Medicines")
public class Medicine {
    @Id
    @Column(name = "Id",columnDefinition = "varchar(36)",nullable = false)
    private String id;
    @Column(name = "Name",columnDefinition = "nvarchar(70)",nullable = false)
    private String name;
    @Column(name = "Quantity",columnDefinition = "int",nullable = false)
    private String quantity;
    @Column(name = "Description",columnDefinition = "nvarchar(MAX)",nullable = false)
    private String description;
    public Medicine() {
        this.id= UUID.randomUUID().toString();
    }
    @ManyToMany
    @JoinTable(name = "PatientsMedicines"
    ,joinColumns = @JoinColumn(name = "Medicine_Id"),
    inverseJoinColumns = @JoinColumn(name = "Patient_Id"))
private Set<Patient> patients;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
