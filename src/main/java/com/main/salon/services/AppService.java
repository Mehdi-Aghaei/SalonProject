package com.main.salon.services;

import com.main.salon.models.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppService {
    List<Appointment> getAllAppointments();
    void saveAppointment(Appointment appointment);
    Appointment getAppointmentById(long id);
    void deleteAppointmentById(long id);
    Page<Appointment> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
