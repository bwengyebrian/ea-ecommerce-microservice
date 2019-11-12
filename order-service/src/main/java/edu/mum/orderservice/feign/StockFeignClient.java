package edu.mum.orderservice.feign;

import edu.mum.orderservice.model.OrderedProduct;
import edu.mum.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

@FeignClient(value = "ea-ecommerce-stockservice",url = "http://temp")
public interface StockFeignClient {

    @GetMapping("/product/{id}/detail")
    public Product getProduct(URI url,@PathVariable("id") long id);

    @GetMapping("/product/all")
    public List<Product> getAllProducts(URI url);

    @GetMapping("/product/{id}/availableItems")
    public Integer getNumberOfProductInTheStock(URI url,@PathVariable("id") int id);

    @PostMapping("/product/reduceStock")
    public void reduceProductStock(URI url,@RequestBody OrderedProduct orderedProduct);
}
