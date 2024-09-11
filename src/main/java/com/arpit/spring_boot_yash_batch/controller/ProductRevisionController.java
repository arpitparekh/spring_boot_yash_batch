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

import com.arpit.spring_boot_yash_batch.model.ProductAnother;
import com.arpit.spring_boot_yash_batch.service.ProductAnotherService;

@Controller
public class ProductRevisionController {

  @Autowired
  ProductAnotherService service;

  @GetMapping("/product_revision")
  public String showProductPage(Model m) {

    // read data
    ArrayList<ProductAnother> list = (ArrayList<ProductAnother>) service.getAllProducts();
    m.addAttribute("products", list);
    System.out.println(list);

    // add empty product for binding
    m.addAttribute("product", new ProductAnother());

    return "product_another";
  }

  @PostMapping("/product_revision")
  public String addProduct(@ModelAttribute("product") ProductAnother product,
      @RequestParam("myFile") MultipartFile file) {
    try {
      if (!file.isEmpty()) {
        product.setImage(file.getBytes());
      }
    } catch (IOException e) {
      System.out.println(e.getMessage().toString());
    }
    service.save(product);
    return "redirect:/product_revision";
  }

    @GetMapping("/product_revision/image/{id}")
    public ResponseEntity<ByteArrayResource> getImageDataOnAdd(@PathVariable Long id) {

      ProductAnother product = service.getProductById(id);

      if (product.getImage() != null) {
        ByteArrayResource resource = new ByteArrayResource(product.getImage());
        return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"image_" + id + ".jpg\"")
            .body(resource);
      } else {
        return ResponseEntity.notFound().build();
      }
    }

    @PostMapping("/product_revision/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
      service.deleteProduct(id);
      return "redirect:/product_revision";
    }

    @PostMapping("/product_revision/update/{id}")
public String updateProduct(@PathVariable Long id, @ModelAttribute("product") ProductAnother product,
                            @RequestParam("myFile") MultipartFile file) {

    ProductAnother existingProduct = service.getProductById(id);

    try {
        if (!file.isEmpty()) {
            existingProduct.setImage(file.getBytes());
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

    // Update other fields
    existingProduct.setName(product.getName());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setDescription(product.getDescription());

    // Update the product in the service
    service.updateProduct(existingProduct);

    return "redirect:/product_revision";
}


}
