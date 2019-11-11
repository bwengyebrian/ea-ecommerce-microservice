package edu.mum.stockservice.repository.initialData;

import edu.mum.stockservice.model.Category;
import edu.mum.stockservice.model.Product;
import edu.mum.stockservice.model.Vendor;
import edu.mum.stockservice.repository.CategoryRepository;
import edu.mum.stockservice.repository.ProductRepository;
import edu.mum.stockservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        populateInitialProducts();
    }

    public void populateInitialProducts(){

        Category c1 = new Category();
        c1.setCategoryName("Electronics");

        Category c2 = new Category();
        c2.setCategoryName("Book");

        Category c3 = new Category();
        c3.setCategoryName("Food");

        Vendor v1 = new Vendor();
        v1.setVendorName("Samsung");

        Vendor v2 = new Vendor();
        v2.setVendorName("Kuraz");

        Vendor v3 = new Vendor();
        v3.setVendorName("Etiye Yimenashu");

        Product p1 = new Product();
        p1.setProductName("LG TV 70 inch");
        p1.setPrice(300);
        p1.setAvailableItems(100);
        p1.setCategory(c1);
        c1.setProducts(p1);
        p1.setVendor(v1);
        v1.setProductList(p1);
        categoryRepository.save(c1);
        vendorRepository.save(v1);
        productRepository.save(p1);

        Product p2 = new Product();
        p2.setProductName("Esat wey abeba");
        p2.setAvailableItems(100);
        p2.setPrice(25);
        p2.setCategory(c2);
        c2.setProducts(p2);
        p2.setVendor(v2);
        v2.setProductList(p2);
        categoryRepository.save(c2);
        vendorRepository.save(v2);
        productRepository.save(p2);


        Product p3 = new Product();
        p3.setProductName("Beyeaynet");
        p3.setAvailableItems(100);
        p3.setPrice(12);
        p3.setCategory(c3);
        c3.setProducts(p3);
        p3.setVendor(v3);
        v3.setProductList(p3);
        categoryRepository.save(c3);
        vendorRepository.save(v3);
        productRepository.save(p3);
    }
}
