package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Categories;

import com.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService cs;
	
	@RequestMapping(value = "category")
	public String opencategory() {
		return "category";
	}
	
	@RequestMapping(value = "storecategory", method = RequestMethod.POST) 
	public String StoreCategory(HttpServletRequest req, Categories c)
	{
		String name = req.getParameter("catname"); 
		c.setName(name);
		
		String result = cs.storeCatalog(c);
		
		if (result == "S") {

			String res = "Category Configured Sucessfully";
			req.setAttribute("msg", res);
			return "category"; //

			// return "Product Configured Sucessfully";
		} else {
			String res = "Category not configured";
			req.setAttribute("msg", res);
			return "category"; //

			// return "Product not Configured ";
		}
	}

}
