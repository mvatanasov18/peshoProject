package com.example.boilerplate.models;

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
    private int patientId;
    private int relativeId;

    public VisitId() {}

    public VisitId(int patientId, int relativeId) {
        this.patientId = patientId;
        this.relativeId = relativeId;
    }
}


