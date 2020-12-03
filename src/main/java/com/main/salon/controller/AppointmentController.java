package com.main.salon.controller;
import com.main.salon.models.Appointment;
import com.main.salon.models.Services;
import com.main.salon.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/appointment")
    public String greetingForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "appointment";
    }

    @PostMapping("/appointment")
    public String greetingSubmit(@Validated Appointment appointment, Model model) {
        appointmentService.createAppointment(appointment);
        return "result";
    }

}
