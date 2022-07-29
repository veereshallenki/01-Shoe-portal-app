package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admins;
import com.dao.AdminDao;
import com.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository ar;

	@Autowired
	AdminDao ad;

	public String validateInput(Admins ll) {

		System.out.println("provided input " + ll.getUserName());

		if (!ll.getUserName().equals("") && !ll.getPwd().equals("")) {
			return "V";
		} else {
			return "email id and pass word can not be Empty";
		}

	}

	public List<Admins> getUserRec(Admins a) {
		return ad.getAdminUserRec(a.getUserName());
	}

	// Method to store data in the Data base
	public String StoreEmp(Admins a) {
//		Optional<Admins> a1 = ar.findById(a.getId());

		String valid_rec = validateInput(a);

		System.out.println("Input validation " + valid_rec);

		if (valid_rec != "V") {
			return valid_rec;
		}

		int res = ar.userCount(a.getUserName());

		System.out.println("User record count value " + res);

		// validate user name and pwd from DB
		if (res == 1) {
			int res2 = ar.userValid(a.getUserName(), a.getPwd());

			if (res2 == 0) {
				return "PE";
			} else {
				return "LS"; // login successfull
			}

		}

		// user record may not exist
		if (!ar.existsByuserName(a.getUserName())) {
			System.out.println("recrod start insert");
			ar.save(a);
			return "S"; // "Record Stored";
		} else {
			return "Record already present";
		}

		/*
		 * if (ar.findByuserName(a.getUserName()) !=null) {
		 * System.out.println("User name recieved " + ar.findByuserName(a.getUserName())
		 * );
		 * 
		 * return "User already exist"; }
		 */

		/*
		 * if (a.getUserName() != null) { ar.save(a); return "Record stored"; } else {
		 * return "Record not stored"; }
		 */

	}

	public String updatePwd(Admins a, String pwd2) {

		if (pwd2 == null) {
			return "rep"; // Re enter Password filed can not be empty
		}

		String valid_rec = validateInput(a);

		if (valid_rec.equals("V")) {

			// passwords should match

			if (a.getPwd() != pwd2) {
				return "rep2"; // Password and re-enter passwords are not mathing
			}

			int res = ar.userCount(a.getUserName());

			if (res == 1) {

				System.out.println("User found and res is " + res);
				
				Admins aa = ar.findByid(a.getUserName());
				
				//int user_id = ad.findUserId2(a.getUserName()); 

				System.out.println("user id " + aa.getId());

				// int res2 = ar.updatePwd(a.getUserName(), pwd2);

				// System.out.println("Update password " + res2);

				return "S1"; // password updated successfully

			} else {
				return "UE"; // User not registred
			}

			// return "a";

		}

		return "a";
	}

}
