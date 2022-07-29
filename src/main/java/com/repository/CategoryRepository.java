package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

	//this for Categories
			public boolean existsByName(String name); 
	
}
