package com.mohitsabhadiya123.InventoryManagementSystem.Controller;

import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Product;
import com.mohitsabhadiya123.InventoryManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = "/saveProducts")
    public ResponseEntity<?> addProduct(@RequestBody List<Product> products){
        try {
            productService.addProducts(products);
            return new ResponseEntity<>("Product Added", HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Bad Request",HttpStatus.BAD_REQUEST);
    }

}
