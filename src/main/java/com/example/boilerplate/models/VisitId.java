package com.example.boilerplate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class VisitId implements Serializable {
    @Column(name = "PatientID")
    private int patientId;
    @Column(name = "RelativeID")
    private int relativeId;

    public VisitId() {}

    public VisitId(int patientId, int relativeId) {
        this.patientId = patientId;
        this.relativeId = relativeId;
    }
}


