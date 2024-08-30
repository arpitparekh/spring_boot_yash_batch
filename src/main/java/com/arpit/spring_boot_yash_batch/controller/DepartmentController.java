package com.arpit.spring_boot_yash_batch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.spring_boot_yash_batch.model.Department;
import com.arpit.spring_boot_yash_batch.service.DepartmentService;

@RestController
public class DepartmentController {

  @Autowired
  DepartmentService service;

  @GetMapping("/department")
  public List<Department> getAllDepartment() {

    // methods will return a response body in api
    return service.getAllDepartment();

  }

  @PostMapping("/department/add")
  public Department addDepartment(@RequestBody Department department) {
    return service.saveDepartment(department);
  }

  @PostMapping("/department/update")
  public Department updateDepartment(@RequestBody Department department) {
    return service.saveDepartment(department);
  }

  @GetMapping("/department/{id}")
  public Department getDepartmentById(@PathVariable Long id) {
    return service.getDepartmentById(id).get();
  }

  @GetMapping("/department/delete/{id}")
  public void deleteDepartmentById(@PathVariable Long id) {
    service.deleteDepartmentById(id);
  }
  
}
