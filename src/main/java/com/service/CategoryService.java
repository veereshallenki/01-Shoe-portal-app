package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.CategoryRepository;
import com.bean.Categories;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository cr;

	public String storeCatalog(Categories c) {
		// if the respective product does not exist in the DB
		if (!cr.existsByName(c.getName())) {
			System.out.println("Category rec start insert");
			// ar.save(p);

			cr.save(c);
			return "S"; // "Record Stored";
		} else {
			return "E"; // Data not stored
		}

	}

}
