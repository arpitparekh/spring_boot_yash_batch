package com.arpit.spring_boot_yash_batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpit.spring_boot_yash_batch.model.AuthenticationModel;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationModel, Long> {

    // interface is a collection of abstract method
    AuthenticationModel findByEmail(String email);

    AuthenticationModel findByPassword(String password);

    // it is used to provide methods to do crud operations and 
    // database manupulation functions
    
}
