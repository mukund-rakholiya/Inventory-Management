package com.mohitsabhadiya123.InventoryManagementSystem.Service;


import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Product;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    public void addProducts(List<Product> products) {
        productRepository.saveAll(products);
    }
}
