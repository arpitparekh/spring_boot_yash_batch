package com.arpit.spring_boot_yash_batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arpit.spring_boot_yash_batch.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
}
