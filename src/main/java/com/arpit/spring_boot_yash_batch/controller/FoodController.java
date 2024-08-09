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
import com.arpit.spring_boot_yash_batch.model.Food;
import com.arpit.spring_boot_yash_batch.service.FoodService;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    FoodService foodService;

    @PostMapping("/add")
    public Food addFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    @GetMapping
    public ApiResponse getAllFood() {
        return new ApiResponse(200, "Success", foodService.getAllFood());
    }

    // @GetMapping("/{id}")
    // public Food getFoodById(@PathVariable Long id) {
    //     return foodService.getFoodById(id);
    // }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getFoodById(@PathVariable Long id) {
        return foodService.getFoodById(id)
                .map(food -> ResponseEntity.ok(new ApiResponse(200, "Success", food)))
                .orElse(ResponseEntity.ok(new ApiResponse(401, "No Food Found", "No Data Found")));
    }

    @GetMapping("/delete/{id}")
    public ApiResponse deleteFoodById(@PathVariable Long id) {
        foodService.deleteFoodById(id);
        return new ApiResponse(200, "Success", "Data Deleted Successfully");

    }

}
