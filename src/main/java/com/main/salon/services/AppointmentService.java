package com.main.salon.services;
import com.main.salon.models.Appointment;
import com.main.salon.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements AppService {
    @Autowired
    private AppointmentRepository AppRepository;
    @Override
    public List<Appointment> getAllAppointments() {

        return AppRepository.findAll();
    }
    @Override
    public void saveAppointment(Appointment appointment) {

        this.AppRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(long id) {
        Optional<Appointment> optional = AppRepository.findById(id);
        Appointment appointment = null;
        if (optional.isPresent()) {
            appointment = optional.get();
        } else {
            throw new RuntimeException(" Appointment not found for id :: " + id);
        }
        return appointment;
    }
    @Override
    public void deleteAppointmentById(long id) {
        this.AppRepository.deleteById(id);
    }

    @Override
    public Page<Appointment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.AppRepository.findAll(pageable);
    }






}