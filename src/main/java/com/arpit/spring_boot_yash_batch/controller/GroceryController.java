package com.arpit.spring_boot_yash_batch.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arpit.spring_boot_yash_batch.model.Grocery;

@Controller
public class GroceryController {
    
    @GetMapping("/grocery")
    public String grocery(Model model) {

        ArrayList<Grocery> list = new ArrayList<>();
        list.add(new Grocery("Vegitables", 20, 200));
        list.add(new Grocery("Ketchup", 2, 90));
        list.add(new Grocery("Oil", 20, 200));
        list.add(new Grocery("Rice", 10, 3000));
        list.add(new Grocery("Wheat", 40, 4000));

        model.addAttribute("groceryList", list);
        
        return "grocery";
    }

}
