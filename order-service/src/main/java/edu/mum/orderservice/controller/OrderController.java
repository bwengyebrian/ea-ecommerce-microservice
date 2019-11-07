package edu.mum.orderservice.controller;

import edu.mum.orderservice.model.Order;
import edu.mum.orderservice.model.Product;
import edu.mum.orderservice.model.User;
import edu.mum.orderservice.service.OrderService;
import edu.mum.orderservice.service.ProductService;
import edu.mum.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;


    @PostMapping("/addToCart/{productId}")
    public Order productsInCart(@PathVariable("productId") int id){

        //get user from userservice
        User user = userService.getUserByUsername("abebe");

        //get the cart
        Order order = orderService.getCart();
        if (order == null){
            order = new Order();
        }

        //get the product - calling the proper api
        //check if there is enough number of items in the stock
        
        Product product = productService.getProductById(id);

        order.getProducts().add(product);

      return orderService.saveOrder(order);

    }

    @PostMapping("/checkout")
    public
}
