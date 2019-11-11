package edu.mum.cs.ea.catalogservice.service;

import edu.mum.cs.ea.catalogservice.dto.Product;

import java.util.List;

public interface CatalogService {
    List<Product> getHomeProducts();
}
