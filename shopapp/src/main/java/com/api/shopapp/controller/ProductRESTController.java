package com.api.shopapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.shopapp.service.ProductService;
import com.api.shopapp.model.Product;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductRESTController
{


    @Autowired
    ProductService productService;



    /**
     * ottiene lista completa dei prodotti
     * @return List Product
     */
    @GetMapping("/api/products")
    public List<Product> getAllProducts()
    {
       return productService.getAll();
    }



    /**
     * ottiene lista di prodotti per nome passato come parametro
     * @param  name
     * @return list product
     */
    @GetMapping("/api/products/name/{name}")
    public List<Product> getProductByName(@PathVariable String name) throws Exception
    {
       return productService.getByName(name);
    }



    /**
     * ritorna un prodotto per id passato come parametro
     * @param id
     * @return Product
     */
   @GetMapping("/api/products/id/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id) throws Exception
   {
      return productService.getById(id);
   }



    /**
     * ritorna una lista di prodotti per prezzo passato come parametro
     * @param  price
     * @return List Product
     */
   @GetMapping("/api/products/price/{price}")
    public List<Product> getProductsByPrice(@PathVariable Double price) throws Exception
   {
       return productService.getByPrice(price);
   }



    /**
     * ritorna una lista di prodotti data una categoria passata come parametro
     * @param category
     * @return list product
     */
   @GetMapping("/api/products/categories/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) throws Exception
   {
       return productService.getByCategory(category);
   }



    /**
     * ritorna una lista di prodotti con la valutazione passata
     * @return List product
     */
   @GetMapping("/api/products/rates/{rate}")
    public List<Product> getProductsByRate(@PathVariable Integer rate) throws Exception
   {
       return productService.getByRate(rate);
   }



    /**
     * ritorna una lista di prodotti con il numero di vendite passato
     * @param sales
     * @return list Product
     */
   @GetMapping("/api/products/sales/{sales}")
    public List<Product> getProductsBySales(@PathVariable Integer sales) throws Exception
   {
       return productService.getBySales(sales);
   }



    /**
     * metodo post, crea un nuovo prodotto, accessibile solo da admin
     * @param product
     * @return Product
     * @throws Exception
     */
    @PostMapping("/api/admin/products/do_add")
    public Product create(@RequestBody Product product) throws Exception
    {
        return productService.saveProduct(product);
    }



    /**
     * aggiorna un prodotto, richiede un id e un body come parametri
     * @param id
     * @param product
     * @return
     */
    @PutMapping("/api/admin/products/update/{id}")
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody Product product)
    {
        return productService.updateProduct(id, product);
    }



}
