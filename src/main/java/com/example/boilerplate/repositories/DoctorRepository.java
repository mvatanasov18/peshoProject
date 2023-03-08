package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
    public Doctor findDoctorByUserId(String userId);
}
