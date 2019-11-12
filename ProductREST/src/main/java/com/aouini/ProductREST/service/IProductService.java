package com.aouini.ProductREST.service;

import java.util.List;
import java.util.Optional;

import com.aouini.ProductREST.exception.ProductNotFoundException;
import com.aouini.ProductREST.exception.ProductNotValidException;
import com.aouini.ProductREST.model.Product;

public interface IProductService
{
	public List<Product> getAll();
	
	public Optional<Product> getById(Integer id) throws ProductNotFoundException;
	
	public List<Product> getByName(String name) throws ProductNotFoundException;
	
	public List<Product> getByType(String type) throws ProductNotFoundException;
	
	public Product saveProduct(Product product) throws ProductNotValidException;
	
	public boolean deleteProduct(Integer id) throws Exception;
	
	public boolean deleteAll();
	
	

}
