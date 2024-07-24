package com.arpit.spring_boot_yash_batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arpit.spring_boot_yash_batch.model.ProductDTO;
import com.arpit.spring_boot_yash_batch.service.ProductService;

@Controller
// @RequestMapping("/products")  // give base urls
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public String showProducts() {
        return "products";
    }

    @GetMapping("/add_product")
    public String showAddProducts(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "add_product";
    }

    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute("product") ProductDTO productDTO) {

        // if (!file.isEmpty()) {
        //     try {
        //         product.setImage(file.getBytes());
        //     } catch (IOException e) {
        //         System.out.println(e.getMessage());
        //     }
        // }

        service.saveProduct(productDTO);

        return "redirect:/products";
    }

}
