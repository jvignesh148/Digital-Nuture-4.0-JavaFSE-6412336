package com.example.service;

import com.example.repository.EmployeeRepository;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void registerEmployee() {
        System.out.println("Registering employee...");
        employeeRepository.saveEmployee();
    }
}
