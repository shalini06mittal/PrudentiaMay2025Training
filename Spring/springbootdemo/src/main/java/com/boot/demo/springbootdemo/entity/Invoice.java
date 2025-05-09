package com.boot.demo.springbootdemo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class Invoice {

    @Id
    @Field("_id")
    private int invoiceid;
    private String deladdress;
    private LocalDate invoicedate;

    private LocalDateTime createdAt;
    private Customer customer;
    private double amount;

    public Invoice() {
    }

    public Invoice(String deladdress, Customer customer, double amount) {
        this.deladdress = deladdress;
        this.invoicedate = LocalDate.now();
        this.customer = customer;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDeladdress() {
        return deladdress;
    }

    public void setDeladdress(String deladdress) {
        this.deladdress = deladdress;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public LocalDate getInvoicedate() {
        return invoicedate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceid=" + invoiceid +
                ", deladdress='" + deladdress + '\'' +
                ", invoicedate=" + invoicedate +
                ", createdAt=" + createdAt +
                ", amount=" + amount +
                '}';
    }
}
