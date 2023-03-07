package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.Receptionist;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.ReceptionistRepository;
import org.springframework.stereotype.Service;

@Service
public class ReceptionistService {
    private final ReceptionistRepository receptionistRepository;
    public ReceptionistService(ReceptionistRepository receptionistRepository){
        this.receptionistRepository=receptionistRepository;
    }
    public Receptionist saveReceptionist(Receptionist receptionist){
        return receptionistRepository.save(receptionist);
    }
    public void deleteReceptionist(Receptionist receptionist){
        receptionistRepository.delete(receptionist);
    }
    public Receptionist findById(String id){
        return receptionistRepository.findById(id).orElse(null);
    }
    public Iterable<Receptionist> findAll(){
        return receptionistRepository.findAll();
    }
}
