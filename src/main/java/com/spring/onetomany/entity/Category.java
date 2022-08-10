package com.spring.onetomany.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	    @Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cate_seq")
	    @SequenceGenerator(initialValue = 1, name = "cate_seq", sequenceName = "category_sequence")
	    private int id;
	    
	    private String categoryName;
	    
	    @OneToMany(mappedBy = "category", 
	    	    cascade = CascadeType.ALL)
	    @JsonIgnore
	    private List<Product> products;
	    
	    
		public Category() {
			super();
		}

		public Category(String categoryName, List<Product> products) {
			super();
			this.categoryName = categoryName;
			this.products = products;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		public int getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Category [id=" + id + ", categoryName=" + categoryName + ", Products=" + products + "]";
		}
	    
	    
	    
}
	
	
	
	

