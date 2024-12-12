package com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;

import java.util.List;

@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_name")
    private String productName;

    @Column(name = "current_price")
    private double currentPrice;

    @Column(name = "mrp")
    private double mrp;

    @Column(name = "discount")
    @Max(99)
    private double discount;

    @Column(name = "inventory")
    private long inventory;

    @Column(name = "gst")
    private double gst;

    @OneToMany(mappedBy = "productOrders",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "tbl_customer_product",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Customer> customersProduct;

    @OneToMany(mappedBy = "billProduct",cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER)
    private List<Bill> productBill;


    public Product() {
    }

    public Product(int productId, String productName, double currentPrice, double mrp, double discount, long inventory, double gst, List<Order> orders, List<Customer> customersProduct, List<Bill> productBill) {
        this.productId = productId;
        this.productName = productName;
        this.currentPrice = currentPrice;
        this.mrp = mrp;
        this.discount = discount;
        this.inventory = inventory;
        this.gst = gst;
        this.orders = orders;
        this.customersProduct = customersProduct;
        this.productBill = productBill;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public long getInventory() {
        return inventory;
    }

    public void setInventory(long inventory) {
        this.inventory = inventory;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Customer> getCustomersProduct() {
        return customersProduct;
    }

    public void setCustomersProduct(List<Customer> customersProduct) {
        this.customersProduct = customersProduct;
    }

    public List<Bill> getProductBill() {
        return productBill;
    }

    public void setProductBill(List<Bill> productBill) {
        this.productBill = productBill;
    }
}
