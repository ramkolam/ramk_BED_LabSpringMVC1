package com.greatlearning.ems.controller;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employees")
    public String listAllEmployees(Model model) {

        List<Employee> employees = employeeService.list();

        model.addAttribute("employees", employees);

        return "list-employees";
    }


    @RequestMapping("/employee/add")
    public String addEmployee(Model theModel) {

        // create model attribute to bind form data
        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employee-form";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(
            @ModelAttribute("employee") Employee employee) {

        // save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees";
    }

    @RequestMapping("/employee/update")
    public String updateEmployee(
            @RequestParam("employeeId") Long employeeId,
            Model theModel) {

        // get the employee from the service
        Employee employee = employeeService.findById(employeeId);

        // set Employee as a model attribute to pre-populate the form
        theModel.addAttribute("employee", employee);

        // send over to our form
        return "employee-form";
    }


    @RequestMapping("/employee/delete")
    public String delete(
            @RequestParam("employeeId") Long employeeId) {

        // delete the Employee
        employeeService.deleteById(employeeId);

        // redirect to Employees-Listing page
        return "redirect:/employees";
    }

}
