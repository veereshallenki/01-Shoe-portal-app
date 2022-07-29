package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.Admins;

//pass the employee class name and primary key column is id and data type is integer
@Repository
public interface AdminRepository extends JpaRepository<Admins, Integer> {

	// when we do control space lot of functions will shows 
		// like find the id, count , exist , delete , delete all , delete by id , exists and findall
	

	
	public String findByuserName(String username); 
	
	public boolean existsByuserName(String username); 
	
	@Query("update Admins u set pass_word = ?2 where user_name = ?1 ")
	public int updatePwd(String username, String pwd); 
	
	@Query("select count(1) from Admins u where user_name = ?1")
	public int userCount(String username); 
	
	@Query("select count(1) from Admins u where user_name = ?1 and pass_word = ?2 ") 
	public int userValid(String username, String pwd);
	
	
	public Admins findByid(String username); 
	
	
	
}
