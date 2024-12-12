package com.mohitsabhadiya123.InventoryManagementSystem.Service;


import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Customer;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addData(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }
}
