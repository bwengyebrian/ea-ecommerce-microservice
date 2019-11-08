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

    @GetMapping("/")
    public String displayOrderService(@ModelAttribute("product") Product product){
        return "orderPage";
    }


    @PostMapping("/addToCart")
    @ResponseBody
    public Order productsInCart(@RequestBody Product product){

//        User user = userService.getUserByUsername("abebe");
        //get user from userservice
        User user = new User();
        user.setUserId(22);
        user.setUsername("abebe");


        //get the cart
        Order order = orderService.getCart(user, false);
        if (order == null){
            order = new Order();
        }

        //get the product - calling the proper api
        //check if there is enough number of items in the stock

        order.setProducts(product);

        //calculate total price
        double totalPrice = 0;
        for (int i=0; i<order.getProducts().size(); i++){
            totalPrice = totalPrice +
                    order.getProducts().get(i).getPrice() * order.getProducts().get(i).getItemOrdered();

        }
        order.setTotalAmount(totalPrice);

      return orderService.saveOrder(order);

    }

    @GetMapping("/placeOrder")
    public String placingOrder(@ModelAttribute("paymentMethod") PaymentMethod paymentMethod, Model model){

        User user1 = new User();
        user1.setUserId(22);
        user1.setUsername("abebe");

        Order order = orderService.getCart(user1, false);
        model.addAttribute("order", order);

        //ask shipping address - get from account service
        //display address form if user want to change shipping address

        return "/productInCart";
    }

    @PostMapping("/checkout")
    @ResponseBody
    public String checkoutOrder(@RequestBody PaymentMethod paymentMethod){

        User user1 = new User();
        user1.setUserId(22);
        user1.setUsername("abebe");

        //get the cart
        Order order = orderService.getCart(user1, false);

        //call payment method service
        //get a string response from payment method service

        //call stock service to reduce the number of available items

        order.setOrderComplete(true);
        orderService.saveOrder(order);

        //call shipping service and provide order detail

        return "You successfully placed an order";
    }

//    @RequestMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello OrderService!";
//    }
}
