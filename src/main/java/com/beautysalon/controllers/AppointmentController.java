package com.beautysalon.controllers;

import com.beautysalon.models.Appointment;
import com.beautysalon.repositories.AppointmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// http://localhost:8080/api/v1/appointment url that shows info

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentRepository AppRepo;
    // we use autowired to get access database tables

    @GetMapping
    public List<Appointment> list(){
        return AppRepo.findAll();
        // the list method will return all  appointments that use get http
    }
    @GetMapping
    @RequestMapping("{id}")
    public Appointment get(@PathVariable Long id) {
        return AppRepo.getOne(id);
    }


    @PostMapping
    public Appointment create(@RequestBody final Appointment appointment){
        return AppRepo.saveAndFlush(appointment);
    }
    // the method will create new appointment in database
    /* the spring will take all attributes in json payload and automatically marshal them
    in Appointment object and then we will pass it in our repository which is part
    of spring data jpa and we can save and flush that when we use jpa and entities
    that save object as we work with that but it doesnt commit it to database until we
    flush that.
     */
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        // Also need to check children methods
        AppRepo.deleteById(id);
        /*
        this Request method can get value and difference methods in this function
        we use the value of id and request method of delete
        but its not needed for get and post mapping
        and the parameter get id and it will pulled up  to path variable same like get
         */
    }
    @RequestMapping(value = "{id}",method = RequestMethod.PUT)
    public Appointment update(@PathVariable Long id,@RequestBody Appointment appointment){
        Appointment existingAppointment = AppRepo.getOne(id);
        BeanUtils.copyProperties(appointment,existingAppointment,"appointment_id");
        return AppRepo.saveAndFlush(existingAppointment);
        /*
        put will get all attributes in request body and will replace them in database record
         */
    }


}


