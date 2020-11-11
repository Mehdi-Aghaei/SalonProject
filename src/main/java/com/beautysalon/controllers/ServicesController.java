package com.beautysalon.controllers;

import com.beautysalon.models.Services;
import com.beautysalon.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/services")
public class ServicesController {
    @Autowired
    private ServicesRepository ServicesRepo;
    @GetMapping
    public List<Services> list(){
        return ServicesRepo.findAll();
    }
    @PostMapping
    public Services create(@RequestBody final Services services){ return ServicesRepo.saveAndFlush(services);}
}
