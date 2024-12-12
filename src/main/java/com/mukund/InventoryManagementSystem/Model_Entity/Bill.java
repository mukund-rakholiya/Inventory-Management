package com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_no")
    private int billNo;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerBill;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product billProduct;

    @Column(name = "total_product")
    private int productQty;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "discount")
    private double discount;

    @Column(name = "gst")
    private double gst;

    public Bill(int billNo, Customer customerBill, Product billProduct, int productQty, double totalAmount, double discount, double gst) {
        this.billNo = billNo;
        this.customerBill = customerBill;
        this.billProduct = billProduct;
        this.productQty = productQty;
        this.totalAmount = totalAmount;
        this.discount = discount;
        this.gst = gst;
    }

    public Bill() {
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
         this.billNo = billNo;
    }

    public Customer getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(Customer customerBill) {
        this.customerBill = customerBill;
    }

    public Product getBillProduct() {
        return billProduct;
    }

    public void setBillProduct(Product billProduct) {
        this.billProduct = billProduct;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }
}
