package edu.mum.cs.ea.catalogservice.controller;

import edu.mum.cs.ea.catalogservice.dto.Product;
import edu.mum.cs.ea.catalogservice.service.feign.StockServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RefreshScope
public class CatalogController {
    @Autowired
    private StockServiceFeign stockServiceFeign;
    //private CatalogService catalogService = new CatalogServiceImpl();
    @RequestMapping("catalog/home/products")
    List<Product> homeProducts(){
        List<Product> products = new ArrayList<>();
        return  (List<Product>) stockServiceFeign.getProducts().getBody();
    }
}
