package com.arpit.spring_boot_yash_batch.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.arpit.spring_boot_yash_batch.model.Product;
import com.arpit.spring_boot_yash_batch.service.ProductService;

@Controller
// @RequestMapping("/products")  // give base urls
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/product/image/{id}")
    public ResponseEntity<ByteArrayResource> getProductImage(@PathVariable Long id) {
        Product product = service.getProductById(id);
        if (product.getImage() != null) {
            ByteArrayResource resource = new ByteArrayResource(product.getImage());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image_" + id + ".jpg\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        ArrayList<Product> list = (ArrayList<Product>) service.getAllProducts();

        model.addAttribute("products", list);

        return "products";
    }

    @GetMapping("/add_product")
    public String showAddProducts(Model model) { // mapping
        model.addAttribute("product", new Product());
        return "add_product";
    }

    // @PostMapping("/add_product")
    // public String addProduct(@ModelAttribute("product") ProductDTO productDTO) {
    //     // if (!file.isEmpty()) {
    //     //     try {
    //     //         product.setImage(file.getBytes());
    //     //     } catch (IOException e) {
    //     //         System.out.println(e.getMessage());
    //     //     }
    //     // }
    //     service.saveProduct(productDTO);
    //     return "redirect:/products";
    // }
    @PostMapping("/add_product")
    public String addProduct(@ModelAttribute("product") Product product,
            @RequestParam("productImage") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            product.setImage(file.getBytes());
        }
        service.saveProduct(product);

        return "redirect:/products";
    }

}
