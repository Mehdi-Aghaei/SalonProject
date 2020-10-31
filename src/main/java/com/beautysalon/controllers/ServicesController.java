package com.beautysalon.controllers;
import com.beautysalon.models.Services;
import com.beautysalon.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class ServicesController {
    @Autowired
    private ServicesRepository ServicesRepository;
    @GetMapping
    public List<Services> list() {
        return ServicesRepository.findAll();
    }


}
