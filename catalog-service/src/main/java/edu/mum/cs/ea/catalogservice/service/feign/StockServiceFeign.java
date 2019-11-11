package edu.mum.cs.ea.catalogservice.service.feign;

import edu.mum.cs.ea.catalogservice.dto.Product;
import edu.mum.cs.ea.catalogservice.utils.RestServiceUrl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(name = "stock-service",url = RestServiceUrl.CATALOG_SERVICE_URL)
public interface StockServiceFeign {
    @GetMapping("/all")
    ResponseEntity<Collection<Product>> getProducts();
}
