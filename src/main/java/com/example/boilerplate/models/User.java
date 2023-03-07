package com.example.boilerplate.models;

import com.example.boilerplate.services.PasswordHasher;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;
@ToString
@EqualsAndHashCode

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
    @Column(name = "First_Name",columnDefinition ="nvarchar(100)",nullable = false)
    private String firstName;
    @Column(name = "Last_Name",columnDefinition ="nvarchar(100)",nullable = false)
    private String lastName;
    @Column(name = "Is_Admin",columnDefinition ="bit",nullable = false)
    private boolean isAdmin;
    @ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "Hospital_Id",columnDefinition ="varchar(36)",referencedColumnName = "Id")
    private Hospital hospital;
    public User(){
        this.id= UUID.randomUUID().toString();
    }

    public User(String id, String username, String password, String firstName, String lastName, boolean isAdmin, Hospital hospital) {
        this.id = id;
        this.username = username;
        setPassword(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
        this.hospital = hospital;
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
        this.password = PasswordHasher.hashPassword(password);
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

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
