package com.example.boilerplate.services;

import com.example.boilerplate.models.Doctor;
import com.example.boilerplate.models.Session;
import com.example.boilerplate.models.User;
import com.example.boilerplate.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final DoctorRepository doctorRepository;
    private final SessionRepository sessionRepository;
    private final PatientRepository patientRepository;
    private final ReceptionistRepository receptionistRepository;
    private final RelativeRepository relativeRepository;
    private final UserRepository userRepository;
    public boolean isDoctor(User user){
       // return doctorRepository.findDoctorByUserId(user.getId())!=null;
        return true;
    }
    public boolean isPatient(User user){
        return patientRepository.findPatientByUserId(user.getId())!=null;
    }
    public boolean isRelative(User user){
        return relativeRepository.findRelativeByUserId(user.getId())!=null;
    }
    public boolean isReceptionist(User user){
        return receptionistRepository.findReceptionistByUserId(user.getId())!=null;
    }

    public String getRole(User user) {
        if (isDoctor(user)) {
            System.out.println("doctor");
            return "doctor";
        }
        if (isPatient(user)) {
            System.out.println("patient");
            return "patient";
        }
        if (isRelative(user)) {
            System.out.println("relative");
            return "relative";
        }
        if (isReceptionist(user)) {
            System.out.println("receptionist");
            return "receptionist";
        }
        return "";
    }

    public String getRoleFromSessionId(String sessionId) {
        Session session = sessionRepository.findById(sessionId).orElseThrow(RuntimeException::new);
        return getRole(session.getUser());
    }

}
