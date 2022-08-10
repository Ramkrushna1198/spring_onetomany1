package com.spring.onetomany.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.onetomany.entity.Category;
import com.spring.onetomany.entity.Product;
import com.spring.onetomany.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
    private ProductService productService;
	
    @GetMapping("/getproducts")
    public ResponseEntity<Product> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }
    
    
    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product pro = productService.addProduct(product);
        return new ResponseEntity<>(pro, HttpStatus.OK);
    }
    
    
    @PutMapping("/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")int id ,@RequestBody Product product) {
    	productService.editProduct(id,product);
    	return ResponseEntity.ok(product);
    			
    }
    
    
    @DeleteMapping("/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
    	productService.deleteProduct(id);
        return new ResponseEntity<>("Product with ID :" + id + " deleted successfully", HttpStatus.OK);
    }
}