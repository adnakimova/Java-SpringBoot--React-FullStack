package com.springer.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springer.demo.business.abstracts.UserService;
import com.springer.demo.core.dataAccess.UserDao;
import com.springer.demo.core.entities.User;
import com.springer.demo.core.utilities.results.DataResult;
import com.springer.demo.core.utilities.results.Result;
import com.springer.demo.core.utilities.results.SuccessDataResult;
import com.springer.demo.core.utilities.results.SuccessResult;
import com.springer.demo.entities.concretes.Product;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		 this.userDao.save(user);
		 return new SuccessResult("User was successfully added!");
		
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		 return new SuccessDataResult <User>("User is found",this.userDao.findByEmail(email));
	}
	
}
