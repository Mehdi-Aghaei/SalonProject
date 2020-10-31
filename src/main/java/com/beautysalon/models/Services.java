package com.beautysalon.models;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity(name = "salon")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;
    private String Service;
    private Integer Price;


    public Services() {
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }
}
