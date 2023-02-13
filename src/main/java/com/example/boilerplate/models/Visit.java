package com.example.boilerplate.models;

import com.example.boilerplate.models.id.VisitId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Visits")
public class Visit {
@EmbeddedId
    private VisitId id;

@Column(name = "VisitTime",columnDefinition = "datetime2(0)",nullable = false)
    private String visitTime;

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
