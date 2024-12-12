package com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity;

import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Embeddables.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int oId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productOrders;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerOrder;

    @Column(name = "Qty")
    @Min(1)
    private int qty;

    @Column(name = "total_amount")
    private double totalAmt;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNo",column = @Column(name = "house_no")),
            @AttributeOverride(name = "society",column = @Column(name = "society")),
            @AttributeOverride(name = "area",column = @Column(name = "area")),
            @AttributeOverride(name = "city",column = @Column(name = "city")),
            @AttributeOverride(name = "pinCode",column = @Column(name = "pin_code"))
    })
    private Address address;


    public Order() {
    }

    public Order(int oId, Product productOrders, Customer customerOrder, int qty, double totalAmt, Address address) {
        this.oId = oId;
        this.productOrders = productOrders;
        this.customerOrder = customerOrder;
        this.qty = qty;
        this.totalAmt = totalAmt;
        this.address = address;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public Product getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(Product productOrders) {
        this.productOrders = productOrders;
    }

    public Customer getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(Customer customerOrder) {
        this.customerOrder = customerOrder;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
