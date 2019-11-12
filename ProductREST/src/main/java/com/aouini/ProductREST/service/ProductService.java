package com.aouini.ProductREST.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.aouini.ProductREST.exception.ProductNotFoundException;
import com.aouini.ProductREST.exception.ProductNotValidException;
import com.aouini.ProductREST.model.Product;
import com.aouini.ProductREST.repository.ProductRepository;


@Service("productService")
public class ProductService implements IProductService {

	
	@Autowired
	ProductRepository productrepository;
	
	
	@Override
	public List<Product> getAll()
	{
		return productrepository.findAll();
	}

	
	@Override
	public Optional<Product> getById(Integer id) throws ProductNotFoundException
	{
		if(productrepository.findById(id).isPresent())
			return productrepository.findById(id);
		else
			throw new ProductNotFoundException("PRODUCT WITH ID: " + id + " NOT FOUND!");
	}

	
	@Override
	public List<Product> getByName(String name) throws ProductNotFoundException
	{
		if(productrepository.findAll().isEmpty())
			throw new ProductNotFoundException("PRODUCT WITH NAME: " + name + " NOT FOUND!");
		
		return productrepository.findByName(name);
	}

	
	@Override
	public List<Product> getByType(String type) throws ProductNotFoundException
	{
		if(productrepository.findAll().isEmpty())
			throw new ProductNotFoundException("PRODUCT NOT FOUND WITH TYPE " + type + ", CHECK TYPE OR DB!");
		else
			return productrepository.getByType(type);
	}

	
	@Override
	public Product saveProduct(Product product) throws ProductNotValidException
	{
		if(product.isValid())
			productrepository.save(product);
		else
			throw new ProductNotValidException("PRODUCT NOT VALID FOR SAVING!");
			
		return product;
	}

	
	@Override
	public boolean deleteProduct(Integer id) throws Exception
	{
		if(id != null)
		{
			productrepository.deleteById(id);
			return true;
		}
		else
		{
			throw new Exception("CAN'T DELETE PRODUCT WITH ID " + id +", ID IS NULL!");
		}
	}

	
	@Override
	public boolean deleteAll()
	{
		productrepository.deleteAll();
		
		if(productrepository.findAll().isEmpty())
			return true;
		else
			return false;
	}


	public Product update(Integer id, Product product)
	{
		return productrepository.updateProduct(id, product);
	}

}
