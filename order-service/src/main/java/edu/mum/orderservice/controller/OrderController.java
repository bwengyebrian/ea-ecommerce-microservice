package edu.mum.orderservice.controller;

import edu.mum.orderservice.feign.AccountFeignClient;
import edu.mum.orderservice.feign.StockFeignClient;
import edu.mum.orderservice.model.*;
import edu.mum.orderservice.service.OrderService;
import edu.mum.orderservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Autowired
    private AccountFeignClient accountFeignClient;
    @Autowired
    private StockFeignClient stockFeignClient;

    @GetMapping("/")
    public String displayOrderService(@ModelAttribute("product") Product product){
        return "orderPage";
    }

    @PostMapping("/")
    @ResponseBody
    public Product displayOrderServiceee(@RequestBody Product product){
        return product;
    }

    @GetMapping("/get")
    @ResponseBody
    public String getOrder(){
        return "you got it";
    }


    @PostMapping("/addToCart")
    @ResponseBody
    public Order productsInCart(@RequestBody Product product){


        Account account = accountFeignClient.getAccount(1);
        System.out.println(account.getFirstName());

        //get the cart
        Order order = orderService.getCart(account.getId());
        if (order == null){
            order = new Order();
        }

        order.setUserid(account.getId());

        //get the product - calling the proper api
        //check if there is enough number of items in the stock

//        order.setProducts(product);
        Product product1 = new Product();
        product1.setProductName(stockFeignClient.getProduct(product.getId()).getProductName());
        product1.setPrice(stockFeignClient.getProduct(product.getId()).getPrice());
        product1.setItemOrdered(product.getItemOrdered());

        order.setProducts(product1);
        productService.saveProduct(product1);

        //calculate total price
        double totalPrice = 0;
        for (int i=0; i<order.getProducts().size(); i++){
            totalPrice = totalPrice +
                    order.getProducts().get(i).getPrice() * order.getProducts().get(i).getItemOrdered();

        }
        order.setTotalAmount(totalPrice);
        orderService.saveOrder(order);

      return orderService.saveOrder(order);

//        return product;

    }

    @GetMapping("/placeOrder")
    public String placingOrder(@ModelAttribute("paymentMethod") PaymentMethod paymentMethod, Model model){

//        User user1 = new User();
//        user1.setUserId(22);
//        user1.setUsername("abebe");
        Account account = accountFeignClient.getAccount(1);
//        user1.setUserid(account.getId());
//        user1.setUsername(account.getFirstName());

        Order order = orderService.getCart(account.getId());
        model.addAttribute("order", order);

        //ask shipping address - get from account service
        //display address form if user want to change shipping address

        return "/productInCart";
    }

    @PostMapping("/checkout")
    @ResponseBody
    public String checkoutOrder(@RequestBody PaymentMethod paymentMethod){

//        User user1 = new User();
//        user1.setUserId(22);
//        user1.setUsername("abebe");
        Account account = accountFeignClient.getAccount(1);
//        user1.setUserid(account.getId());
//        user1.setUsername(account.getFirstName());

        //get the cart
        Order order = orderService.getCart(account.getId());

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
