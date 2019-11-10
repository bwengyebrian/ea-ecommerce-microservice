package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.OrderedProduct;
import edu.mum.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ea-ecommerce-stockservice")
public interface StockFeignClient {

    @GetMapping("/product/{id}/detail")
    public Product getProduct(@PathVariable("id") long id);

    @GetMapping("/product/all")
    public List<Product> getAllProducts();

    @GetMapping("/product/{id}/availableItems")
    public Integer getNumberOfProductInTheStock(@PathVariable("id") int id);

    @PostMapping("/product/reduceStock")
    public void reduceProductStock(@RequestBody OrderedProduct orderedProduct);
}
