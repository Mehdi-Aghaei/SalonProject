package com.beautysalon.models;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "appointment")
// we use @entity to define our database table name for this model
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
// this annotation is for to ignore those properties these two will load all relational data and will cause problem
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id;
    private String full_name;
    private String phone_number;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date appointment_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Services services;

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
/*
    these attribute that we define up is equal to columns in database
    and @Id and generated values is for our primary key and with these config spring data jpa will handle
    our connection to database
     */

    public Appointment() {

    }

    public Long getAppointment_id() {

        return appointment_id;
    }

    public void setAppointment_id(Long appointment_id) {
        this.appointment_id = appointment_id;
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
