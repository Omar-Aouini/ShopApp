package com.aouini.ProductREST.repository;

import java.util.List;

import org.hibernate.boot.model.relational.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.aouini.ProductREST.model.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(value = "FROM product WHERE name = ?1")
	public List<Product> findByName(String name);

	
	@Query(value = "FROM product WHERE type = ?1")
	public List<Product> getByType(String type);

	@Modifying
	@Query(value = "UPDATE product p set p.product WHERE p.id = ?1")
	public Product updateProduct(Integer id, Product product);
		
	
}


