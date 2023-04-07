package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface DoctorRepository extends JpaRepository<Doctor,String> {
   // Doctor findDoctorByUserId(String id);
}
