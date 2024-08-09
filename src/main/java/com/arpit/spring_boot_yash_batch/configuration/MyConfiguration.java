package com.arpit.spring_boot_yash_batch.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arpit.spring_boot_yash_batch.DB1;

@Configuration
public class MyConfiguration {
    

    // i can create beans

    @Bean
    DB1 getDb1() {
        return new DB1();
    }

}
