package edu.mum.orderservice.controller;

import edu.mum.orderservice.feign.AccountFeignClient;
import edu.mum.orderservice.feign.PaymentMethodFeignClient;
import edu.mum.orderservice.feign.ShippingFeignClient;
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
    @Autowired
    private ShippingFeignClient shippingFeignClient;

    @GetMapping("/")
    public String displayOrderService(@ModelAttribute("product") Product product){
        return "orderPage";
    }


    @PostMapping("/addToCart")
    @ResponseBody
    public Order productsInCart(@RequestBody Product product){
        product.setProductIdInStock(product.getId());

        Account account = accountFeignClient.getAccount(2);
//        System.out.println(account.getFirstName());

        //get the cart
        Order order = orderService.getCart(account.getId());
        if (order == null){
            order = new Order();
        }

        order.setUserid(account.getId());

        //get the product - calling the proper api
        //check if there is enough number of items in the stock

        Product product1 = new Product();
        product1.setProductIdInStock(product.getProductIdInStock());
        product1.setProductName(stockFeignClient.getProduct(product.getProductIdInStock()).getProductName());
        double price = stockFeignClient.getProduct(product.getProductIdInStock()).getPrice();
        product1.setPrice(price);
        product1.setItemOrdered(product.getItemOrdered());

        productService.saveProduct(product1);
        order.setProducts(product1);

        //calculate total price
        double totalPrice = 0;
        for (int i=0; i<order.getProducts().size(); i++){
            totalPrice += order.getProducts().get(i).getPrice() * order.getProducts().get(i).getItemOrdered();

        }
        order.setTotalAmount(totalPrice);
        orderService.saveOrder(order);
        product1.setOrder(order);
        productService.saveProduct(product1);

      return order;

    }

    @PostMapping("/placeOrder")
    @ResponseBody
    public Order placingOrder(@RequestBody PaymentMethod method){

        Account account = accountFeignClient.getAccount(2);

        Order order = orderService.getCart(account.getId());

        //contact payment service
//        String paymentResponse = paymentMethodFeignClient.makePayment(method.getPaymentMethodType());

        order.setPaymentType(method.getPaymentMethodType());
//        order.setPaymentStatus(paymentResponse);
        orderService.saveOrder(order);

        return order;
    }

    @PostMapping("/checkout")
    @ResponseBody
    public String checkoutOrder(@RequestBody Address address){

        Account account = accountFeignClient.getAccount(2);

        //get the cart
        Order order = orderService.getCart(account.getId());

        //call payment method service
//        String paymentMade = paymentMethodFeignClient.paymentMade();
        System.out.println(order.getPaymentType());
        String paymentResponse = paymentMethodFeignClient.makePayment("credit");
        order.setPaymentStatus(paymentResponse);

        //call stock service to reduce the number of available items
        OrderedProduct orderedProduct = new OrderedProduct();
        for (int i = 0; i<order.getProducts().size(); i++){
            orderedProduct.setId(order.getProducts().get(i).getProductIdInStock());
            orderedProduct.setAmount(order.getProducts().get(i).getItemOrdered());
            stockFeignClient.reduceProductStock(orderedProduct);
        }

        order.setOrderComplete(true);
        order = orderService.saveOrder(order);

        String orderSuccessMsg = "You successfully placed an order: ";
        String orderedProductList = "";
        for(int i =0; i<order.getProducts().size(); i++){
            orderedProductList = orderedProductList + "| " + order.getProducts().get(i).getProductName() + " - quantity= " +
                    order.getProducts().get(i).getItemOrdered();
        }
        orderSuccessMsg = orderSuccessMsg + " " + orderedProductList + ". ";

        //Send item and address to shipping service
//        ItemToShip item = new ItemToShip();
//        item.setOrder(order);
//        item.setAddress(address);
//        String shippingDetail = shippingFeignClient.initiateShipping(item);
        String shippingDetail = shippingFeignClient.initiateShipping();


        return orderSuccessMsg + "| " + order.getPaymentStatus() + " | " + shippingDetail;
    }

}
