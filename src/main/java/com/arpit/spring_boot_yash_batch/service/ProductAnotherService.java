package com.arpit.spring_boot_yash_batch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.ProductAnother;
import com.arpit.spring_boot_yash_batch.repository.ProductAnotherRepository;

@Service
public class ProductAnotherService {

  @Autowired
  ProductAnotherRepository repo;

  public void save(ProductAnother product) {
    repo.save(product);
  }

  public ProductAnother getProductById(Long id) {
    Optional<ProductAnother> product = repo.findById(id);
    return product.orElse(null); // Return the product if found, otherwise return null
  }

  public List<ProductAnother> getAllProducts() {
    return repo.findAll();
  }

  public void deleteProduct(Long id) {
    repo.deleteById(id);
  }

  public void updateProduct(ProductAnother product) {
        if (repo.existsById(product.getId())) {
            repo.save(product); // Save the updated product data
        } else {
            throw new RuntimeException("Product not found with ID: " + product.getId());
        }
    }


}
