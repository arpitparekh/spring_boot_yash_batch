package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arpit.spring_boot_yash_batch.model.AuthenticationModel;
import com.arpit.spring_boot_yash_batch.service.AuthenticationService;

@Controller
public class AuthenticationController {

    @Autowired
    AuthenticationService service;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/welcome")
    public String showWelcome() {
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {

        if (service.matchEmail(email) != null && service.matchPassword(password) != null) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Wrong Credentials");
            return "login";
        }
    }

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, Model model) {

        if (service.matchEmail(email) != null) {
            model.addAttribute("error", "Email already exsist");
            return "/register";

        } else {

            AuthenticationModel auth = new AuthenticationModel();
            auth.setEmail(email);
            auth.setPassword(password);

            service.addData(auth);

            return "redirect:/login";
        }
    }
}
