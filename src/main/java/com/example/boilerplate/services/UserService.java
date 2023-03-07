package com.example.boilerplate.services;

import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.User;
import com.example.boilerplate.repositories.HospitalRepository;
import com.example.boilerplate.repositories.TreatmentRepository;
import com.example.boilerplate.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public void deleteUser(User user){
        userRepository.delete(user);
    }
    public User findById(String id){
        return userRepository.findById(id).orElse(null);
    }
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }
}
