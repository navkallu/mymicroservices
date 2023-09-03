package com.navexmp.employeeservice.controller;

import com.navexmp.employeeservice.model.Employee;
import com.navexmp.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeRepository repository;
    @PostMapping
    public Employee add(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}",employee);
        return repository.addEmployee(employee);
    }
    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("find All called in Controller");
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee find: id={}",id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        LOGGER.info("Employee find: departmentId={}",departmentId);
        return repository.findByDepartment(departmentId);
    }


}
