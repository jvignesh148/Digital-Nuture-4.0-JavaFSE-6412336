package com.cognizant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
    @Id
    private String code;
    private String name;

    // Getters and Setters
    public String getCoCode() {
        return code;
    }

    public void setCoCode(String code) {
        this.code = code;
    }

    public String getCoName() {
        return name;
    }

    public void setCoName(String name) {
        this.name = name;
    }
}
