package com.arpit.spring_boot_yash_batch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.Food;
import com.arpit.spring_boot_yash_batch.repository.FoodRepository;

@Service
public class FoodService {

    @Autowired
    FoodRepository repository;

    public Food saveFood(Food food) {
        return repository.save(food);
    }

    public List<Food> getAllFood() {
        return repository.findAll();
    }

    public Optional<Food> getFoodById(Long id) {
        return repository.findById(id);
    }

    public void deleteFoodById(Long id) {
        repository.deleteById(id);
    }
    
}
