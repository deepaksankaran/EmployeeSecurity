package com.employeesecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.employeesecurity.model.Employee;
import com.employeesecurity.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/employee", method = RequestMethod.GET)
    public List<Employee> listUser(){
        return employeeService.findAll();
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id){
        employeeService.delete(id);
        return "success";
    }

}
