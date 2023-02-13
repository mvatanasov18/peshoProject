package com.example.boilerplate.models.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class VisitId implements Serializable {
    @Column(name = "PatientId")
    private String patientId;
    @Column(name = "RelativeId")
    private String relativeId;

    public String getPatientId() {
        return patientId;
    }

    public String getRelativeId() {
        return relativeId;
    }
}
