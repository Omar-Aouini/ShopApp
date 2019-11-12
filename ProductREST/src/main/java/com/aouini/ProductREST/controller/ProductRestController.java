package com.aouini.ProductREST.controller;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aouini.ProductREST.exception.ProductNotFoundException;
import com.aouini.ProductREST.exception.ProductNotValidException;
import com.aouini.ProductREST.model.Product;
import com.aouini.ProductREST.service.ProductService;


@RestController
public class ProductRestController
{
	
	@Autowired
	ProductService productservice;
	
	
	@GetMapping("/")
	public List<Product> productList()
	{
		return productservice.getAll();
	}
	
	
	@GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") Integer id) throws ProductNotFoundException
	{
        return productservice.getById(id);
    }
	
	
	@PostMapping("/do_add")
    public Product create(@RequestBody Product product) throws ProductNotValidException {
        return productservice.saveProduct(product);
    }
	
	
	@PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productservice.update(id, product);
    }

}
