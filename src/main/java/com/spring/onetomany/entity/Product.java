package com.spring.onetomany.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	@SequenceGenerator(initialValue = 1, name = "product_seq", sequenceName = "product_sequence")
    private int id;
    
    private String productname;
    
    @ManyToOne(cascade=CascadeType.ALL,
    		fetch = FetchType.LAZY) 
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Category category;
    
    
	public Product() {
		super();
	}

	
	public Product(String productname, Category category) {
		super();
		this.productname = productname;
		this.category = category;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productname=" + productname + ", category=" + category + "]";
	}
	
   
	
    
}
