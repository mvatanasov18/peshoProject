package com.example.boilerplate.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Visits")
@Data
public class Visit {
    @EmbeddedId
    private VisitId visitId;

    @ManyToOne
    @JoinColumn(name = "PatientID", insertable = false, updatable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "RelativeID", insertable = false, updatable = false)
    private Relative relative;
    @Column(name = "VisitTime")
    private Date visitTime;
}

