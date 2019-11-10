package edu.mum.stockservice.serviceImpl;

import edu.mum.stockservice.model.Product;
import edu.mum.stockservice.repository.ProductRepository;
import edu.mum.stockservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product fetchProdut(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product reduceStock(long id, int ammout) {
        Product product = fetchProdut(id);
        product.setAvailableItems(product.getAvailableItems() - ammout);

        return saveProduct(product);
    }
}
