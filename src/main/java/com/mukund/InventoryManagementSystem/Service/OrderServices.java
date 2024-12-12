package com.mohitsabhadiya123.InventoryManagementSystem.Service;


import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Bill;
import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Customer;
import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Order;
import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Product;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.BillRepository;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.CustomerRepository;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.OrderRepository;
import com.mohitsabhadiya123.InventoryManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private MessageServices customerMsgServices;


    public void sendOrder(Order order) {
        Product product = productRepository.findById(order.getProductOrders().getProductId()).get();
        Customer customer = customerRepository.findById(order.getCustomerOrder().getCustomer_id()).get();
        if (payment()) {
            customer.getOrders().add(order);
            customer.getProducts().add(product);

            product.getCustomersProduct().add(customer);

            // Calculate Total Amount
            double productPrice = product.getCurrentPrice();
            int qty = order.getQty();
            double totalAmount = productPrice*qty;
            order.setTotalAmt(totalAmount);


            // Qty calculate for Product
            long oldQty = product.getInventory();
            product.setInventory(oldQty-qty);


            // For set Bill
            Bill bill = new Bill();
            bill.setCustomerBill(customer);
            bill.setBillProduct(product);
            bill.setProductQty(qty);
                // gst calculate
                double gst = product.getGst();
                double withGstAmount = totalAmount+(totalAmount*(product.getGst())/100);

                double discount = product.getDiscount();
                double finalAmount = withGstAmount - ((withGstAmount*discount)/100);
                bill.setTotalAmount(finalAmount);

            bill.setDiscount(discount);
            bill.setGst(gst);

            orderRepository.save(order);
            customerRepository.save(customer);
            productRepository.save(product);
            billRepository.save(bill);

            customerMsgServices.sendWhatsapp(customer.getMobileNo(),"Order Placed Successfully");
            customerMsgServices.sendSMS(customer.getMobileNo(),"Order Placed Successfully");

        }
    }

    public boolean payment() {
        return new Random().nextBoolean();
    }
}
