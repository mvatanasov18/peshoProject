package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.Visit;
import com.example.boilerplate.models.id.VisitId;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.VisitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VisitService {
    private final VisitRepository visitRepository;

    public Visit saveVisit(Visit visit){
        return visitRepository.save(visit);
    }
    public void deleteVisit(Visit visit){
        visitRepository.delete(visit);
    }
    public Visit findById(VisitId id){
        return visitRepository.findById(id).orElse(null);
    }
    public Iterable<Visit> findAll(){
        return visitRepository.findAll();
    }
}
