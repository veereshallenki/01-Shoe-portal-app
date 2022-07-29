package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Products;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository ar;
	
	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

	// Method to store data in the Data base
	public String StoreProduct(Products p) {

		// if the respective product does not exist in the DB
		if (!ar.existsByName(p.getName())) {
			System.out.println("Product rec start insert");
			// ar.save(p);  
			p.setDateAdded(date);
			ar.save(p);
			return "S"; // "Record Stored";
		} else {
			return "E"; // Data not stored
		}

		// return "a";
	}

}
