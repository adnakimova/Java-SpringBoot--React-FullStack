package com.springer.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springer.demo.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
//	select *from products where product_name = "smth"
	Product getByProductName(String productName);
	
//	select *from products where product_name = "smth" and category_id = 1
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

//	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String startsWith);
	
//	jpql ??
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
}
