package edu.mum.orderservice.controller;

import edu.mum.orderservice.feign.AccountFeignClient;
import edu.mum.orderservice.feign.PaymentMethodFeignClient;
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
    @Autowired
    private PaymentMethodFeignClient paymentMethodFeignClient;

    @GetMapping("/")
    public String displayOrderService(@ModelAttribute("product") Product product){
        return "orderPage";
    }


    @PostMapping("/addToCart")
    @ResponseBody
    public Order productsInCart(@RequestBody Product product){
        product.setProductIdInStock(product.getId());

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
        product1.setProductIdInStock(product.getProductIdInStock());
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

    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public String placingOrder(@RequestBody PaymentMethod paymentMethod, Model model){

        Account account = accountFeignClient.getAccount(1);

        Order order = orderService.getCart(account.getId());
        model.addAttribute("order", order);

        //contact payment service
        String paymentType = paymentMethodFeignClient.paymentType();
        order.setPaymentType(paymentMethod.getPaymentMethodType());
        orderService.saveOrder(order);

        return paymentType + order.getPaymentType();
    }

    @GetMapping("/checkout")
    @ResponseBody
    public String checkoutOrder(){

        Account account = accountFeignClient.getAccount(1);

        //get the cart
        Order order = orderService.getCart(account.getId());

        //call payment method service
        String paymentMade = paymentMethodFeignClient.paymentMade();

        //call stock service to reduce the number of available items
        OrderedProduct orderedProduct = new OrderedProduct();
        for (int i = 0; i<order.getProducts().size(); i++){
            orderedProduct.setId(order.getProducts().get(i).getProductIdInStock());
            orderedProduct.setAmount(order.getProducts().get(i).getItemOrdered());
            stockFeignClient.reduceProductStock(orderedProduct);
        }


        order.setOrderComplete(true);
        orderService.saveOrder(order);

        //call shipping service and provide order detail
        String orderSuccessMsg = "You successfully placed an order: " +
                "Your order: " ;
        String orderedProducts = "";
        for(int i =0; i<order.getProducts().size(); i++){
            orderedProducts + order.getProducts().get(i).getProductName() + " "
        }

        return "You successfully placed an order";
    }

}
