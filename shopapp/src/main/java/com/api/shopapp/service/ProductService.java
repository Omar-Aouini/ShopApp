package com.api.shopapp.service;

import com.api.shopapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.shopapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service("productService")
public class ProductService implements IProductService
{

    @Autowired
    ProductRepository productRepository;



    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }



    @Override
    public List<Product> getByName(String name) throws Exception {
        if(name != null && !name.equals(""))
            return productRepository.getByName(name);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH NAME " + name + ", NAME IS NULL OR EMPTY!");
    }



    @Override
    public Optional<Product> getById(Integer id) throws Exception {
        if(id != null && id > 0)
            return productRepository.findById(id);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH ID " + id + ", ID IS NULL OR NOT VALID!");
    }



    @Override
    public List<Product> getByPrice(Double price) throws Exception {
        if(price != null && price >= 0)
            return productRepository.findByPrice(price);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH PRICE " + price + ", PRICE IS NULL OR NOT VALID!");
    }



    @Override
    public List<Product> getByCategory(String category) throws Exception {
        if(category != null && !category.equals(""))
            return productRepository.getByCategory(category);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH CATEGORY " + category + ", CATEGORY IS NULL OR NOT VALID!");
    }



    @Override
    public List<Product> getByRate(Integer rate) throws Exception {
        if(rate != null && rate >= 0)
            return productRepository.getByRate(rate);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH RATE " + rate + ", RATE IS NULL OR NOT VALID!");
    }



    @Override
    public List<Product> getBySales(Integer sales) throws Exception {
        if(sales != null && sales >= 0)
            return productRepository.getBySales(sales);
        else
            throw new Exception("CANNOT FIND PRODUCT WITH SALES " + sales + ", SALES IS NULL OR NOT VALID!");
    }



    @Override
    public Product updateProduct(Integer id, Product product)
    {
        return productRepository.updateProduct(id, product);
    }



    @Override
    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

}
