package com.example.boilerplate.repositories;

import com.example.boilerplate.models.DischargeSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DischargeSummaryRepository extends JpaRepository<DischargeSummary,String> {
}
