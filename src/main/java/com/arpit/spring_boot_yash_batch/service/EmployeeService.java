package com.arpit.spring_boot_yash_batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.Employee;
import com.arpit.spring_boot_yash_batch.repository.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository repository;

  // insert
  public Employee insert(Employee employee) {
    return repository.save(employee);
  }


}
