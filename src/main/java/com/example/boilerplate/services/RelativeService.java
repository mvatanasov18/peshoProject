package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.Relative;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.RelativeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RelativeService {
    private final RelativeRepository relativeRepository;

    public Relative saveRepository(Relative relative){
        return relativeRepository.save(relative);
    }
    public void deleteRelative(Relative relative){
        relativeRepository.delete(relative);
    }
    public Relative findById(String id){
        return relativeRepository.findById(id).orElse(null);
    }
    public Iterable<Relative> findAll(){
        return relativeRepository.findAll();
    }
}
