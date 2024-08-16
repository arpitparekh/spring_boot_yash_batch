package com.arpit.spring_boot_yash_batch.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.arpit.spring_boot_yash_batch.model.Country;

import reactor.core.publisher.Flux;

@Service
public class CountryService {


    @Autowired
    WebClient webClient;

    public static final Logger logger = LogManager.getLogger(CountryService.class);

    public Flux<Country> getCities(){
        return webClient.get()
        .uri("https://countriesnow.space/api/v0.1/countries/population/cities")
        .retrieve()
        .bodyToFlux(Country.class)
        .doOnError(throwable -> logger.error("Failed for some reason", throwable.getMessage()));
    }
    
}
