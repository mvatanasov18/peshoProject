package com.example.boilerplate.models;

import com.example.boilerplate.models.id.VisitId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "Visits")
public class Visit {
@EmbeddedId
    private VisitId id;

@Column(name = "Visit_Time",columnDefinition = "datetime2(0)",nullable = false)
    private String visitTime;

    public Visit() {

    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }
}
