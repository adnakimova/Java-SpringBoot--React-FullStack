package com.springer.demo.business.abstracts;

import com.springer.demo.core.entities.User;
import com.springer.demo.core.utilities.results.DataResult;
import com.springer.demo.core.utilities.results.Result;
import com.springer.demo.entities.concretes.Product;

public interface UserService {
	Result add(User user);
	DataResult<User> findByEmail(String email);
}
