package com.main.salon.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import javax.persistence.Id;
import java.util.List;


@Entity(name="services")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long service_id;
    private String service_name;
    private Integer service_price;

    public Services(){
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Integer getService_price() {
        return service_price;
    }

    public void setService_price(Integer service_price) {
        this.service_price = service_price;
    }

}
