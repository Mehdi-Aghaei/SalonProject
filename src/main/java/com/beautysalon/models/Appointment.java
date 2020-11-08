package com.beautysalon.models;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity(name = "appointment")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
// this annotation is for to ignore those properties these two will load all relational data and will cause problem
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointment_id;
    private String full_name;
    private Integer phone_number;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date appointment_date;


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

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Date getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(Date appointment_date) {
        this.appointment_date = appointment_date;
    }
}
