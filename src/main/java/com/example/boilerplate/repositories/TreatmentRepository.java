package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment,String> {
}
