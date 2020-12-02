package com.main.salon.services;
import com.main.salon.models.Appointment;
import com.main.salon.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository AppRepo;

    public Appointment createAppointment(Appointment appointment){
        AppRepo.save(appointment);
       return appointment;
    }
}