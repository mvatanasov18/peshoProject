package com.example.boilerplate.services;

import com.example.boilerplate.models.Medicine;
import com.example.boilerplate.repositories.AddressRepository;
import com.example.boilerplate.repositories.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicineService {
    private final MedicineRepository medicineRepository;

    public Medicine saveMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }
    public void deleteMedicine(Medicine medicine){
        medicineRepository.delete(medicine);
    }
    public Medicine findById(String id){
        return medicineRepository.findById(id).orElse(null);
    }
    public Iterable<Medicine> findAll(){
        return medicineRepository.findAll();
    }
}
