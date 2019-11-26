package com.api.shopapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.api.shopapp.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{

    @Query(value = "SELECT * FROM PRODUCT WHERE NAME = ?1" ,nativeQuery = true)
    List<Product> getByName(String name);

    @Query(value = "SELECT * FROM PRODUCT WHERE PRICE = ?1" ,nativeQuery = true)
    List<Product> findByPrice(Double price);

    @Query(value = "SELECT * FROM PRODUCT WHERE CATEGORY = ?1" ,nativeQuery = true)
    List<Product> getByCategory(String category);

    @Query(value = "SELECT * FROM PRODUCT WHERE RATE = ?1" ,nativeQuery = true)
    List<Product> getByRate(Integer rate);

    @Query(value = "SELECT * FROM PRODUCT WHERE SALES = ?1" ,nativeQuery = true)
    List<Product> getBySales(Integer sales);


    @Modifying                  //TODO
    @Query(value = "UPDATE product p set p.product where p.id = ?1")
    public Product updateProduct(Integer id, Product product);
}
