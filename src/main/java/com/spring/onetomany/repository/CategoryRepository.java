package com.spring.onetomany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.onetomany.entity.Category;
import com.spring.onetomany.entity.Product;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	

}
