package com.example.boilerplate.services;

import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.User;
import com.example.boilerplate.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ReceptionistRepository receptionistRepository;
    private final RelativeRepository relativeRepository;
    private final UserRepository userRepository;
    public boolean isDoctor(User user){
        return doctorRepository.findDoctorByUserId(user.getId())!=null;
    }
    public boolean isPatient(User user){
        return patientRepository.findPatientByByUserId(user.getId())!=null;
    }
    public boolean isRelative(User user){
        return relativeRepository.findRelativeByUserId(user.getId())!=null;
    }
    public boolean isReceptionist(User user){
        return receptionistRepository.findReceptionistByUserId(user.getId())!=null;
    }

}
