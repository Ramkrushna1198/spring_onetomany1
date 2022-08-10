package com.spring.onetomany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.onetomany.entity.Category;
import com.spring.onetomany.entity.Product;
import com.spring.onetomany.repository.CategoryRepository;
import com.spring.onetomany.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
    private ProductRepository productRepository;
	
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product addProduct(Product product) {
        Category cate = categoryRepository.findById(product.getCategory().getId()).orElse(null);
        if (cate==null) {
        	cate = new Category();
        }
        cate.setCategoryName(product.getCategory().getCategoryName());
        product.setCategory(cate);
        return productRepository.save(product);
    }
    
    public Product editProduct(int id,Product product) {
        return productRepository.save(product);
    }
    
    
    public void deleteProduct(int id) {
    	productRepository.deleteById(id);
    }



}
