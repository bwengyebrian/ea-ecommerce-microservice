package edu.mum.stockservice.service;

import edu.mum.stockservice.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> fetchAllProducts();
    Product fetchProdut(long id);
    Product reduceStock(long id, int ammout);
}
