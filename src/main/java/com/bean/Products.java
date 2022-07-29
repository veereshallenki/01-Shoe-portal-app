package com.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products") 
public class Products {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated value
	@Column (name = "ID")
	private int id;
	@Column (name = "name")
	private String name; 
	
	@Column (name = "price")
	private int price;
	
	@Column (name="date_added")
	private Date dateAdded;
	
	@Column (name="category_id")
	private int categoryId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded
				+ ", categoryId=" + categoryId + "]";
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	} 
	
	
	
}
