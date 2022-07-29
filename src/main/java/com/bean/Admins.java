package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admins {

	@Id // primary key column
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generated value
	@Column(name = "ID")
	private int id;
	@Column(name = "user_name")
	private String userName;

	@Column(name = "pass_word")
	private String pwd;

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", pwd=" + pwd + "]";
	}

	public Admins() {
		super();
	}

}
