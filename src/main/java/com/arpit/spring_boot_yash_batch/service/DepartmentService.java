package com.arpit.spring_boot_yash_batch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.Department;
import com.arpit.spring_boot_yash_batch.repository.DepartmentRepository;

@Service
public class DepartmentService {

  @Autowired
  DepartmentRepository repository;


  // save (insert and update)
  public Department saveDepartment(Department department) {
    return repository.save(department);
  }

  // get all deppartment
  public List<Department> getAllDepartment() {
    return repository.findAll();
  }

  // get department by id
  public Optional<Department> getDepartmentById(Long id) {
    return repository.findById(id);
  }

  // delete
  public void deleteDepartmentById(Long id) {
    repository.deleteById(id);
  }

}
