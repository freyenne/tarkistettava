package com.example.harjoitustyo2019.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    
    @Column(name = "productName", nullable = false)
    private String productName;
    
    @Column(name = "productPrice", nullable = false)
    private String productPrice;
    
    @Column(name = "supplier", nullable = false)
    private String supplier;
    
    @Column(name = "category", nullable = false)
    private String category;

	public Product(int id, String productName, String productPrice, String supplier, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.supplier = supplier;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice + ", supplier="
				+ supplier + ", category=" + category + "]";
	}

    
    

}
