package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bean.*;
import com.service.AdminService;

@Controller
public class ShoeController {

	@Autowired
	AdminService as;

	@RequestMapping(value = "abc")
	public String getDemo1() {
		System.out.println("form demo1 jsp");
		return "demo1"; // it must be same name of the JSP
	}

	@RequestMapping(value = "login")
	public String openLogin() {
		return "login";
	}

	@RequestMapping(value = "login2")
	public String openLogin2() {
		return "login2";
	}

	@RequestMapping(value = "forgotpwd")
	public String forgotPwd() {
		return "forgotpwd";
	}

	@RequestMapping(value = "checkuser", method = RequestMethod.POST)
	public String userCheck(HttpServletRequest req) {

		System.out.println("request recieved");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		if (email.equals("vallenki@vmware.com") && password.equals("12345")) {
			return "demo1"; // demo1 jsp
		} else {
			return "demo1"; // demo2 jsp
		}

	}

	@RequestMapping(value = "storeadmin", method = RequestMethod.POST)
	public String stroeAdmin(HttpServletRequest req, Admins a) {

		System.out.println("request recieved");
		String email = req.getParameter("email");
		System.out.println("email recieved is " + email);
		String password = req.getParameter("password");
		System.out.println("Password recieved is " + password);
		a.setUserName(email);
		a.setPwd(password);

		String result = as.StoreEmp(a);

		System.out.println("Result from service layyer is  " + result);

		if (result == "S") {
			String res = "Admin Sign up is succss and welcome to shoe portal  " + email;
			req.setAttribute("msg", res);
			return "demo1"; // it will return to demo1 page

		} else if (result == "PE") {
			String res = "Password is in correct and please try again  " + email;
			System.out.println("Result is " + res);
			req.setAttribute("msg", res);
			// return "login2"; // it will return to demo1 page
			return "forgotpwd";
		} else if (result == "LS") {
			String res = "Login Succeful     " + email;
			req.setAttribute("msg", res);
			return "demo1"; // it will r
		}

		else {
			System.out.println("Result is " + result);
			req.setAttribute("msg", result);
			return "login2"; // it will return to demo1 page
		}

	}

	@RequestMapping(value = "chgpwd", method = RequestMethod.POST)
	public String updatePass(HttpServletRequest req, Admins a) {
		System.out.println("request recieved");
		String email = req.getParameter("email");
		System.out.println("email recieved is " + email);
		String password = req.getParameter("password");
		System.out.println("Password recieved is " + password);
		String password2 = req.getParameter("password");
		System.out.println("Re enter Password recieved is " + password2);

		a.setUserName(email);
		a.setPwd(password);

		String result = as.updatePwd(a, password2);
		if (result == "S1") {
			String res = "password updated successfully";
			req.setAttribute("msg", res);
			return "demo1"; // back to demo1 page
		} else if (result == "rep") {
			String res = "Re enter Password filed can not be empty";
			req.setAttribute("msg", res);
			return "forgotpwd";
		} else if (result == "rep2") {
			String res = "Password and re-enter passwords are not matching";
			req.setAttribute("msg", res);
			return "forgotpwd";
		} else if (result == "UE") {
			String res = "Admin not registred! Register the user ";
			req.setAttribute("msg", res);
			return "login2";
		} 
		else {
			String res = "email id and pass word can not be Empty";

			req.setAttribute("msg", res);
			return "forgotpwd"; // it will
		}

		/*
		 * if (result == "S1") { String res = "password updated successfully";
		 * req.setAttribute("msg", res); return "demo1"; // back to demo1 page }
		 * 
		 * if (result == "rep") { String res =
		 * "Re enter Password filed can not be empty"; req.setAttribute("msg", res);
		 * return "forgotpwd"; // it will r } if (result == "rep2") { String res =
		 * "Password and re-enter passwords are not matching"; req.setAttribute("msg",
		 * res); return "forgotpwd"; // it will r }
		 * 
		 * if (result == "UE") { String res = "Admin not registred! Register the user ";
		 * req.setAttribute("msg", res); return "login2"; // it will r }
		 * 
		 * if (result != "V") { String res = "email id and pass word can not be Empty";
		 * 
		 * req.setAttribute("msg", res); return "forgotpwd"; // it will }
		 */

		// return "aa";
	}

}
