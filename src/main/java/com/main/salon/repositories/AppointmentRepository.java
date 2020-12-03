package com.main.salon.repositories;
import com.main.salon.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
to create a data jpaRepository in spring we just have to extend the jpaRepository with the name
of our model class and the primary key type and this handle all the things like post and get
request from server to data base and so on...
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
