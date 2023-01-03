package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "specialty")
    private String specialty;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "role")
    private String role;

    public String getFirstName() {
        return user.getFirstName();
    }

    public String getLastName() {
        return user.getLastName();
    }
}

