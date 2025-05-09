package com.boot.demo.springbootdemo.service;


import com.boot.demo.springbootdemo.entity.Invoice;
import com.boot.demo.springbootdemo.repo.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public Invoice getInvoiceByInvoiceId(int id){
        return invoiceRepo.findById(id)
                .orElseThrow(()->  new RuntimeException("customer with "+id+" does not exists"));
    }
    public Invoice insertInvoice(Invoice invoice){
        if(invoiceRepo.existsById(invoice.getInvoiceid()))
            throw new RuntimeException("Cannot add "+invoice.getInvoiceid()+" already exists");
        return invoiceRepo.save(invoice);
    }

    public List<Invoice> getAllInvoicesByCustomerId(int customerid){
        return  invoiceRepo.findAllByCustomerId(customerid);
    }
}
