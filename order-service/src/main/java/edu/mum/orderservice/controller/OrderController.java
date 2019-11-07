package edu.mum.orderservice.controller;

import edu.mum.orderservice.model.Order;
import edu.mum.orderservice.model.PaymentMethod;
import edu.mum.orderservice.model.Product;
import edu.mum.orderservice.model.User;
import edu.mum.orderservice.service.OrderService;
import edu.mum.orderservice.service.ProductService;
import edu.mum.orderservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;


    @PostMapping("/addToCart/{productId}")
    @ResponseBody
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

        //calculate total price
        order.setTotalAmount(order.getTotalAmount() + product.getPrice());

        order.getProducts().add(product);


      return orderService.saveOrder(order);

    }

    @GetMapping("/placeOrder")
    public String placingOrder(@ModelAttribute("paymentMethod") PaymentMethod paymentMethod, Model model){

        Order order = orderService.getCart();
        model.addAttribute("order", order);

        //ask shipping address
        User user = userService.getUserByUsername("abebe");

        model.addAttribute("user", user);

        return "/productInCart";
    }

    @PostMapping("/checkout{userId}")
    @ResponseBody
    public String checkoutOrder(@PathVariable("userId") int userId, @RequestBody PaymentMethod paymentMethod){

        //get user from userservice -- using the userId
        User user = userService.getUserByUsername("abebe");

        //get the cart
        Order order = orderService.getCart();

        //call payment method service
        //get a string response from payment method service

        //call stock service to reduce the number of available items

        order.setOrderComplete(true);
        orderService.saveOrder(order);

        //call shipping address and provide order detail

        return "You successfully placed an order";
    }
}
