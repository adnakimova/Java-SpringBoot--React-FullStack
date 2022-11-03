package com.springer.demo.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springer.demo.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String email);
}
