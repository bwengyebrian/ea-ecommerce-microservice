package edu.mum.orderservice.service;

import edu.mum.orderservice.model.Product;

public interface ProductService {

    Product saveProduct(Product product);
    Product getProductById(long id);
}
