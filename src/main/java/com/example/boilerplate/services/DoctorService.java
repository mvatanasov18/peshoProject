package com.example.boilerplate.services;

import com.example.boilerplate.models.Address;
import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.repositories.AddressRepository;
import com.example.boilerplate.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    public void deleteDoctor(Doctor doctor){
        doctorRepository.delete(doctor);
    }
    public Doctor findById(String id){
        return doctorRepository.findById(id).orElse(null);
    }
    public Iterable<Doctor> findAll(){
        return doctorRepository.findAll();
    }
}
