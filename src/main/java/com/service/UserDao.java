package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.BusBean;
import com.model.UserBean;

@Repository
public interface UserDao extends JpaRepository<UserBean, String>{

	
	public UserBean findByName(String name);
	
}
