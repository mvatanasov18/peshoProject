package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.Patient;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }
    public void deletePatient(Patient patient){
        patientRepository.delete(patient);
    }
    public Patient findById(String id){
        return patientRepository.findById(id).orElse(null);
    }
    public Iterable<Patient> findAll(){
        return patientRepository.findAll();
    }
}
