package com.greatlearning.ems.service.impl;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.repository.EmployeeRepository;
import com.greatlearning.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> list() {

        return employeeRepository.findAll();
    }


    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public Employee findById(Long employeeID) {
        return employeeRepository.findById(employeeID).get();
    }


    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}