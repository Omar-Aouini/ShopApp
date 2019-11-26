package com.api.shopapp.service;


import com.api.shopapp.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService
{

    List<Product> getAll();

    List<Product> getByName(String name) throws Exception;

    Optional<Product> getById(Integer id) throws Exception;

    List<Product> getByPrice(Double price) throws Exception;

    List<Product> getByCategory(String category) throws Exception;

    List<Product> getByRate(Integer rate) throws Exception;

    List<Product> getBySales(Integer sales) throws Exception;

    Product updateProduct(Integer id, Product product);

    Product saveProduct(Product product);
}
