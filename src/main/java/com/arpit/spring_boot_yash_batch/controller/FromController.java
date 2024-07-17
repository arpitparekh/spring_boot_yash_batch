package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arpit.spring_boot_yash_batch.model.FormData;

@Controller
public class FromController {
    
    @GetMapping("/form")                              // get the page
    public String getForm(Model model) {

        model.addAttribute("fromData", new FormData());
        return "form";
    }

    @PostMapping("/form")                              // get the page
    public String sendDataForm(@ModelAttribute FormData fromData,Model model) {
        model.addAttribute("fromData",fromData);
        return "form_display";
    }
}
