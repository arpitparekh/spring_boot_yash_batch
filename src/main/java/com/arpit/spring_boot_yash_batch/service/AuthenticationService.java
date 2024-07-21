package com.arpit.spring_boot_yash_batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.AuthenticationModel;
import com.arpit.spring_boot_yash_batch.repository.AuthenticationRepository;

@Service
public class AuthenticationService {

    // main bussiness logic

    @Autowired
    AuthenticationRepository repository;

    public AuthenticationModel matchEmail(String email) {
        return repository.findByEmail(email);
    }

    public AuthenticationModel addData(AuthenticationModel model) {
        return repository.save(model);
    }

}


