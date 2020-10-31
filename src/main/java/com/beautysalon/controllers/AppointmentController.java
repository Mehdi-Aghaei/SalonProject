package com.beautysalon.controllers;

import com.beautysalon.models.Appointment;
import com.beautysalon.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentRepository AppRepo;

    @GetMapping("/")
    public String ShowPage(Model model){
        model.addAttribute("data",AppRepo.findAll());
        return "index";
    }
    @PostMapping("/save")
    public String save(Appointment app){
        AppRepo.save(app);
        return "redirect:/";

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



}


