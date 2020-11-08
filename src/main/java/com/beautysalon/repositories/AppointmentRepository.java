package com.beautysalon.repositories;
import com.beautysalon.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
