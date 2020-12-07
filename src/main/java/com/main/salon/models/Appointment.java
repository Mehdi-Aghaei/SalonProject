package com.main.salon.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;


@Entity
@Table(name="appointment")
// we use @entity to define our database table name for this model
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
// this annotation is for to ignore those properties these two will load all relational data and will cause problem
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String full_name;
    private String phone_number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appointment_date;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Services services;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Appointment(String full_name, String phone_number, Date appointment_date, Services services) {
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.appointment_date = appointment_date;
        this.services = services;
    }
/*
    these attribute that we define up is equal to columns in database
    and @Id and generated values is for our primary key and with these config spring data jpa will handle
    our connection to database
     */

    public Appointment() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }




}
