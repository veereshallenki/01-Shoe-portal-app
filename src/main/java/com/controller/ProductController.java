package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Products;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService ps;

	@RequestMapping(value = "products")
	public String openproducts() {
		return "products";
	}

	@RequestMapping(value = "storeproduct", method = RequestMethod.POST) // pass under value exact action name under //
																			// products jsp page
	public String storeProduct(HttpServletRequest req, Products p) {

		System.out.println("Product config request recieved");
		String name = req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		int cid = Integer.parseInt(req.getParameter("categoryid"));
		p.setName(name);
		p.setPrice(price);
		p.setCategoryId(cid);
		p.setDateAdded(null);

		String result = ps.StoreProduct(p);
		if (result == "S") {

			String res = "Product Configured Sucessfully";
			req.setAttribute("msg", res);
			return "products"; //

			// return "Product Configured Sucessfully";
		} else {
			String res = "Product not configured";
			req.setAttribute("msg", res);
			return "products"; //

			// return "Product not Configured ";
		}

	}

}
