package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Visit;
import com.example.boilerplate.models.id.VisitId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, VisitId> {
}
