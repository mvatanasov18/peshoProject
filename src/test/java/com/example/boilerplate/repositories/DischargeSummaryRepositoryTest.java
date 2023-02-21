package com.example.boilerplate.repositories;

import com.example.boilerplate.BoilerplateApplication;
import com.example.boilerplate.models.DischargeSummary;
import com.example.boilerplate.models.Hospital;
import com.example.boilerplate.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BoilerplateApplication.class)
public class DischargeSummaryRepositoryTest {
@Autowired
    private DischargeSummaryRepository repository;
@Test
    private void testSaveDischargeSummary(){

    Hospital hospital=mock(Hospital.class);
    when(hospital.getId()).thenReturn(UUID.randomUUID().toString());
    when(hospital.getName()).thenReturn("Deva Maria");



    User patientUser=mock(User.class);
    when(patientUser.getId()).thenReturn(UUID.randomUUID().toString());
    when(patientUser.getUsername()).thenReturn("Ivan");
when(patientUser.getPassword()).thenReturn("tooshort");
when(patientUser.getFirstName()).thenReturn("Milko");
when(patientUser.getLastName()).thenReturn("Ivanov");
when(patientUser.getIsAdmin()).thenReturn(false);



}
}
