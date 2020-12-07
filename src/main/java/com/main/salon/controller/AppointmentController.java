package com.main.salon.controller;
import com.main.salon.models.Appointment;
import com.main.salon.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listAppointment", appointmentService.getAllAppointments());
        return "index";
    }

    @GetMapping("/showNewAppointmentForm")
    public String showNewAppointmentForm(Model model) {
        // create model attribute to bind form data
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "new_appointment";
    }
    @PostMapping("/saveAppointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        // save Appointment to database
        appointmentService.saveAppointment(appointment);
        return "redirect:/";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get appointment from the service
        Appointment appointment = appointmentService.getAppointmentById(id);

        // set appointment as a model attribute to pre-populate the form
        model.addAttribute("appointment", appointment);
        return "update_appointment";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.appointmentService.deleteAppointmentById(id);
        return "redirect:/";
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Appointment> page = appointmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Appointment> listAppointment = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listAppointment);
        return "index";
    }




}
