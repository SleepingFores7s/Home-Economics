package com.example.homeeconomics.economic.receipt.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.sql.Date;

@Entity
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_name", nullable = true)
    private String storeName;

    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;

    @Column(name = "total_receipt_cost")
    private Double totalCost;

    @Column(name = "category")
    private String category;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
