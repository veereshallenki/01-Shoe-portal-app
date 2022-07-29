package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Admins;

@Repository
public class AdminDao {

	@Autowired
	EntityManagerFactory emf;

	public int findEmployee(String username) {

		EntityManager em = emf.createEntityManager();
		Admins a = em.find(Admins.class, username);

		if (a != null) {
			return 1; // that means record already exist
		} else {
			return 0; // user not exists
		}

	}

	public List<Admins> getAdminUserRec(String username) {
		EntityManager em = emf.createEntityManager();		
		
		Query q = em.createQuery("select e from Admins e where user_name = :username");
		List<Admins> listOfusers = q.getResultList();
		return listOfusers;

	}

	public int findUserId2(String username) {
		EntityManager man = emf.createEntityManager();
		Admins a = man.find(Admins.class, username); 

		if (a != null) {
			return a.getId();
		} else {
			return 0;
		}

	}

	public int findUserId(String username) {

		// Admins result;
		int final_res = 0;
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("select e.id from Admins e where user_name = ?"); // JPQL java persistance Query lang
		List<Admins> listOfAdmins = q.getResultList();

		if (listOfAdmins.size() != 0) {
			System.out.println("Record found thru SQl");
			for (Admins userid : listOfAdmins) {
				final_res = userid.getId();
			}
		}
		return final_res;

	}

	public int updateUser(Admins a, String pwd2) {
		EntityManager em = emf.createEntityManager();
		// em.createNativeQuery(pwd2)

		return 1;
	}

}
