package com.example.boilerplate.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "Id",nullable = false, columnDefinition = "varchar(36)")
    private String id;

    @Column(name = "Username",nullable = false,unique = true,columnDefinition = "varchar(100)")
    private String username;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "FirstName",columnDefinition ="nvarchar(100)",nullable = false)
    private String firstName;
    @Column(name = "LastName",columnDefinition ="nvarchar(100)",nullable = false)
    private String lastName;
    @Column(name = "IsAdmin",columnDefinition ="bit",nullable = false)
    private String isAdmin;
    @ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "HospitalId",columnDefinition ="varchar(36)",referencedColumnName = "Id")
    private Hospital hospital;
    public User(){
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
