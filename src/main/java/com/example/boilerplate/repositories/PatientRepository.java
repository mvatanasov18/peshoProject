package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}
