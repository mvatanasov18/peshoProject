package com.example.boilerplate.models;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DateOfBirth",nullable = false)
    private String dateOfBirth;

    @ElementCollection
    @Column(name = "ArrivalTimestamps",nullable = false)
    private List<Instant> arrivalTimestamps;

    @ElementCollection
    @Column(name = "DepartureTimestamps")
    private List<Instant> departureTimestamps;


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
