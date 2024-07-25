package com.arpit.spring_boot_yash_batch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.Product;
import com.arpit.spring_boot_yash_batch.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> getAllProducts() { // show data

        return repository.findAll();
    }
    
    public Product getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElse(null);  // Return the product if found, otherwise return null
    }
    
    public void saveProduct(Product product) {  // save data
        repository.save(product);
    }

    public void deleteProduct(Long id) { // delete data
        repository.deleteById(id);
    }

    public Optional<Product> updateProduct(Long id) {  // update data
        return repository.findById(id);
    }

}
