package edu.mum.stockservice;

import edu.mum.stockservice.model.Category;
import edu.mum.stockservice.model.Product;
import edu.mum.stockservice.model.Vendor;
import edu.mum.stockservice.service.CategoryService;
import edu.mum.stockservice.service.ProductService;
import edu.mum.stockservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
