package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.Treatment;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreatmentService {
    private final TreatmentRepository treatmentRepository;

    public Treatment saveTreatment(Treatment treatment){
        return treatmentRepository.save(treatment);
    }
    public void deleteTreatment(Treatment treatment){
        treatmentRepository.delete(treatment);
    }
    public Treatment findById(String id){
        return treatmentRepository.findById(id).orElse(null);
    }
    public Iterable<Treatment> findAll(){
        return treatmentRepository.findAll();
    }
}
