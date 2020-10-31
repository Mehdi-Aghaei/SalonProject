package com.beautysalon.controllers;
import com.beautysalon.models.Appointment;
import com.beautysalon.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping
    public List<Appointment> list() {
        return appointmentRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Appointment get(@PathVariable Long id) {
        return appointmentRepository.getOne(id);
    }

    @PostMapping
    public Appointment create(@RequestBody final Appointment session) {
        return appointmentRepository.saveAndFlush(session);
    }

    /*@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        appointmentRepository.deleteById(id);
    }*/
}


