package com.example.boilerplate.repositories;


import com.example.boilerplate.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,String> {
    public Patient findPatientByUserId(String userId);

    @Query(value = "SELECT "+
            "p.Id " +
            "p.DateOfBirth " +
            "p.Condition " +
            "p.SurgeryRequired " +
            "p.UserId " +
            "FROM Patients p " +
            "inner join Users u ON u.Id=p.UserId " +
            "WHERE u.HospitalId=:id; ",nativeQuery = true)
    List<Patient> findAllByHospitalId(@Param("id")String id);
}
