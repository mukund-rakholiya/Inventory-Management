package com.mohitsabhadiya123.InventoryManagementSystem.Controller;


import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Customer;
import com.mohitsabhadiya123.InventoryManagementSystem.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/addData")
    public ResponseEntity<?> addData(@RequestBody @Validated List<Customer> customers) {
            customerService.addData(customers);
            return new ResponseEntity<>("Customer Added", HttpStatus.CREATED);
    }
}
