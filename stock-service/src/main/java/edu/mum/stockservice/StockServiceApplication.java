package edu.mum.stockservice;

import edu.mum.stockservice.model.Category;
import edu.mum.stockservice.model.Product;
import edu.mum.stockservice.model.Vendor;
import edu.mum.stockservice.repository.CategoryRepository;
import edu.mum.stockservice.repository.ProductRepository;
import edu.mum.stockservice.repository.VendorRepository;
import edu.mum.stockservice.service.CategoryService;
import edu.mum.stockservice.service.ProductService;
import edu.mum.stockservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StockServiceApplication implements ApplicationRunner {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private VendorService vendorService;


//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

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
        p1.setProductName("LG");
        p1.setAvailableItems(100);
        p1.setCategory(c1);
        c1.setProducts(p1);
        p1.setVendor(v1);
        v1.setProductList(p1);
        categoryService.saveCategory(c1);
        vendorService.saveVendor(v1);
        productService.saveProduct(p1);

        Product p2 = new Product();
        p2.setProductName("LG");
        p2.setAvailableItems(100);
        p2.setCategory(c2);
        c2.setProducts(p1);
        p2.setVendor(v2);
        v2.setProductList(p2);
        categoryService.saveCategory(c2);
        vendorService.saveVendor(v2);
        productService.saveProduct(p2);


        Product p3 = new Product();
        p3.setProductName("LG");
        p3.setAvailableItems(100);
        p3.setCategory(c3);
        c3.setProducts(p3);
        p3.setVendor(v3);
        p3.setPrice(20.0);
        v3.setProductList(p3);
        categoryService.saveCategory(c3);
        vendorService.saveVendor(v3);
        productService.saveProduct(p3);

    }
}
