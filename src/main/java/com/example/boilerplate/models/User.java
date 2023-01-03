package com.example.boilerplate.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Table(name = "Users")
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Username",nullable = false)
    private String username;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "Address",nullable = false)
    private String address;
    @Column(name = "PhoneNumber",nullable = false)
    private String phoneNumber;
    @Column(name = "FirstName",nullable = false)
    private String firstName;
    @Column(name = "LastName",nullable = false)
    private String lastName;
}
