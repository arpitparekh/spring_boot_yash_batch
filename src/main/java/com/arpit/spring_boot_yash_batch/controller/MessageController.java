package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arpit.spring_boot_yash_batch.model.Message;
import com.arpit.spring_boot_yash_batch.model.User;

@Controller
public class MessageController {
    
    @GetMapping("/home")
    @ResponseBody
    public String loadPage(
        @RequestParam("name")
        String name
    ) {
        return "<html><body><p>This is a " + name + " batch Webpage.</p></body></html>";
    }

    @GetMapping("/fromThyme")
    public String function(@RequestParam("value") String name, Model model) {

        Message message = new Message();
        message.setData(name);

        // message.data
        model.addAttribute(message);
        return "home";
    }

    @PostMapping("/one")
    public String pageOne(@ModelAttribute User user,Model model) {
        model.addAttribute("User", user);
        return "page_one";
    }
    
}
