package com.mohitsabhadiya123.InventoryManagementSystem.Controller;


import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Order;
import com.mohitsabhadiya123.InventoryManagementSystem.Service.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping("/send-order")
    public ResponseEntity<?> sendOrder(@RequestBody Order order){
        try{
            orderServices.sendOrder(order);
            return new ResponseEntity<>("Order send Successfully",HttpStatus.CREATED);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("Order not Added", HttpStatus.BAD_REQUEST);
    }
}
