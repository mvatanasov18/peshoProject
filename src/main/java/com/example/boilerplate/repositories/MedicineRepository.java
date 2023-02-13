package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,String> {
}
