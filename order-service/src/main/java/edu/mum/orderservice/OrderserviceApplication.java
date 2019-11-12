package edu.mum.orderservice;

import edu.mum.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class OrderserviceApplication {

    @Autowired
    private ProductService productService;

//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(OrderserviceApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        User user1 = new User();
////        User user2 = new User();
////        user1.setUsername("abebe");
////        user2.setUsername("bekele");
////        userService.saveUser(user1);
////        userService.saveUser(user2);
////
////
////        Product p1 = new Product();
////        Product p2 = new Product();
////        p1.setProductName("LG TV");
////        p1.setPrice(1000);
////        p2.setProductName("BeyeAynet");
////        p2.setPrice(25);
////        productService.saveProduct(p1);
////        productService.saveProduct(p2);
//
//    }
}
