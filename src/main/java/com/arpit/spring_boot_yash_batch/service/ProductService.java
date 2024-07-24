package com.arpit.spring_boot_yash_batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.spring_boot_yash_batch.model.ProductDTO;
import com.arpit.spring_boot_yash_batch.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    // public List<ProductDTO> getAllProducts() {  // show data
    //     return repository.findAll();
    // }

    public void saveProduct(ProductDTO product) {  // save data
        repository.save(product);
    }

    // public void deleteProduct(Long id) { // delete data
    //     repository.deleteById(id);
    // }

    // public Optional<ProductDTO> updateProduct(Long id) {  // update data
    //     return repository.findById(id);
    // }

}
