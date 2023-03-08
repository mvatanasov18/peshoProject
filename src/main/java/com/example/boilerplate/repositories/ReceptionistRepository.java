package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<Receptionist,String> {
     public Receptionist findReceptionistByUserId(String userId);
}
