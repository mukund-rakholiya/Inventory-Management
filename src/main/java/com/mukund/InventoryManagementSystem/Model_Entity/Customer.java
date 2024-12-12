package com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @NotBlank(message = "Invalid Username")
    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "mobile",unique = true)
    @Pattern(regexp = "^[1-9][0-9]{9}$",message = "invalid phone number")
    private String mobileNo;

    @Column(name="email",unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z A-Z]{2,3}$",message = "invalid email")
    private String email;

    @OneToMany(mappedBy = "customerOrder",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders;

    @ManyToMany(mappedBy = "customersProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product> products;

    @OneToMany(mappedBy = "customerBill",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Bill> bills;


    public Customer() {
    }

    public Customer(int customer_id, String customerName, String mobileNo, String email, List<Order> orders, List<Product> products, List<Bill> bills) {
        this.customerId = customer_id;
        this.customerName = customerName;
        this.mobileNo = mobileNo;
        this.email = email;
        this.orders = orders;
        this.products = products;
        this.bills = bills;
    }

    public int getCustomer_id() {
        return customerId;
    }

    public void setCustomer_id(int customer_id) {
        this.customerId = customer_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
