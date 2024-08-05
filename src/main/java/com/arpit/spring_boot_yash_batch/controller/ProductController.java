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
    public ResponseEntity<ByteArrayResource> getImageDataOnList(@PathVariable Long id) {

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

    @GetMapping("/add_product/image/{id}")
    public ResponseEntity<ByteArrayResource> getImageDataOnAdd(@PathVariable Long id) {

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

    @GetMapping("/add_product/{id}")
    public String showUpdateProducts(@PathVariable Long id, Model model) { // mapping

        Product product = service.getProductById(id);

        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return "redirect:/products";
    }

    @PostMapping("/add_product")
    public String addOrUpdateProduct(@ModelAttribute("product") Product product,
            @RequestParam("productImage") MultipartFile file) throws IOException {

        if (product.getId() != null) {

            Product existingProduct = service.getProductById(product.getId());
            if (existingProduct != null) {

                existingProduct.setName(product.getName());
                existingProduct.setDescription(product.getDescription());
                existingProduct.setPrice(product.getPrice());

                if (!file.isEmpty()) {
                    existingProduct.setImage(file.getBytes());
                }

                service.saveProduct(existingProduct);
            }
        } else {

            if (!file.isEmpty()) {
                product.setImage(file.getBytes());
            }
            service.saveProduct(product);
        }

        return "redirect:/products";
    }

}
