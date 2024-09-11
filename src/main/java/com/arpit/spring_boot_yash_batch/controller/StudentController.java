package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.spring_boot_yash_batch.model.ApiResponse;
import com.arpit.spring_boot_yash_batch.model.Student;
import com.arpit.spring_boot_yash_batch.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

  @Autowired
  StudentService studentService;

  @PostMapping("add")
  public ApiResponse saveStudent(@RequestBody Student student) {
    return new ApiResponse(200, "Student Save Scuccessfully", studentService.saveStudent(student));
  }

  @GetMapping("getAll")
  public ApiResponse getAllStudent() {
    return new ApiResponse(200, "All Students", studentService.getAllStudent());
  }

  @GetMapping("getById/{id}")
  public ResponseEntity<ApiResponse> getStudentById(@PathVariable("id") Long id) {

    return studentService.getStudent(id)
        .map(student -> ResponseEntity.ok(new ApiResponse(200, "Success", student)))
        .orElse(ResponseEntity.ok(new ApiResponse(401, "No Food Found", "No Data Found")));
  }

  @GetMapping("delete/{id}")
  public ApiResponse deleteStudent(@PathVariable("id") Long id) {
    studentService.deleteStudent(id);
    return new ApiResponse(200, "Success", "Data Deleted Successfully");
  }

  @PostMapping("update")
  public ApiResponse updateStudent(@RequestBody Student student) {
    studentService.updateStudent(student);
    return new ApiResponse(200, "Success", "Data Updated Successfully");
  }

}
