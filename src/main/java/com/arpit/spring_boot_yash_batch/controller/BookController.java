package com.arpit.spring_boot_yash_batch.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arpit.spring_boot_yash_batch.model.Books;

@Controller
public class BookController {
    
    @GetMapping("/books")
    public String ShowBooks(Model model) {

        ArrayList<Books> books = new ArrayList<>();

        books.add(new Books("Walden", "Thoreau"));
        books.add(new Books("Harry Potter", "JK Rollings"));
        books.add(new Books("One night ad call center", "Chetan Bhagat"));
        books.add(new Books("India @2020", "Abdul kalam"));
        books.add(new Books("Sherlock Holmes", "Arthur cannon doyle"));
        

        model.addAttribute("books", books);

        return "books";
    }

}
