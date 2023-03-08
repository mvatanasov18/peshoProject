package com.example.boilerplate.services;

import com.example.boilerplate.models.DischargeSummary;
import com.example.boilerplate.repositories.DischargeSummaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DischargeSummaryService {
    private final DischargeSummaryRepository dischargeSummaryRepository;



    public DischargeSummary saveDischargeSummary(DischargeSummary dischargeSummary) {
        return dischargeSummaryRepository.save(dischargeSummary);
    }

    public void deleteDischargeSummary(DischargeSummary dischargeSummary) {
        dischargeSummaryRepository.delete(dischargeSummary);
    }

    public DischargeSummary findById(String id) {
        return dischargeSummaryRepository.findById(id).orElse(null);
    }

    public Iterable<DischargeSummary> findAll() {
        return dischargeSummaryRepository.findAll();
    }
}
