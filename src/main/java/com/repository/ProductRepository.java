package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Products;

 
@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

	//this for products
		public boolean existsByName(String name); 
}
