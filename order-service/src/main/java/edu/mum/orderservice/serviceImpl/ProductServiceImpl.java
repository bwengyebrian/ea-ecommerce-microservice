package edu.mum.orderservice.serviceImpl;

import edu.mum.orderservice.model.Product;
import edu.mum.orderservice.repository.ProductRepository;
import edu.mum.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }
}
