package com.arpit.spring_boot_yash_batch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.Student;
import com.arpit.spring_boot_yash_batch.repository.StudentRepo;

@Service
public class StudentService {

  @Autowired
  StudentRepo studentRepo;

  // get all data // intsert // update // delete

  public Student saveStudent(Student student) {
    return studentRepo.save(student);
  }

  public Optional<Student> getStudent(Long id) {
    return studentRepo.findById(id);
  }

  public void deleteStudent(Long id) {
    studentRepo.deleteById(id);
  }

  public void updateStudent(Student student) {

    Optional<Student> s = studentRepo.findById(student.getId());

    if(s.isPresent()){
      studentRepo.save(student);
    }

  }

  public List<Student> getAllStudent() {
    return studentRepo.findAll();
  }

}
