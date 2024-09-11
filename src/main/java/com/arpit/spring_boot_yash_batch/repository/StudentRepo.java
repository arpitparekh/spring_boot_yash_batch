package com.arpit.spring_boot_yash_batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpit.spring_boot_yash_batch.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

  // You can add custom query methods here if needed
  
}
