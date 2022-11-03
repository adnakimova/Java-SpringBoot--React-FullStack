package com.springer.demo.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.springer.demo.core.utilities.results.DataResult;
import com.springer.demo.core.utilities.results.Result;
import com.springer.demo.entities.concretes.Product;


public interface ProductService {
	DataResult<List<Product>> getAll();
	Result add(Product product);
	
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	

//	select *from products where product_name = "smth"
	DataResult<Product> getByProductName(String productName);
	
//	select *from products where product_name = "smth" and category_id = 1
	DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

//	
	DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);
	
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String startsWith);
	
	
	
}
