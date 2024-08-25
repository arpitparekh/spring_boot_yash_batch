package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arpit.spring_boot_yash_batch.model.Employee;
import com.arpit.spring_boot_yash_batch.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  EmployeeService service;

  // add employee
    @GetMapping("/add")
    public String add() {
      service.insert(new Employee("Yash", null));
      return ResponseEntity.ok().build().toString();
    }
}
