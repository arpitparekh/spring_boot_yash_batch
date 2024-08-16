package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.spring_boot_yash_batch.service.CountryService;

import reactor.core.publisher.Flux;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;
    
    @GetMapping("/getCountries")
    public Flux<?> getCountry1() {
        try {
            return countryService.getCities();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}
