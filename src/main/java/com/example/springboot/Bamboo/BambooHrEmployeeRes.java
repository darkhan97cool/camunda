package com.example.springboot.Bamboo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class BambooHrEmployeeRes implements Serializable {

    private List<BambooHrEmployee> employees;

    public List<BambooHrEmployee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<BambooHrEmployee> employees) {
        this.employees = employees;
    }
}
