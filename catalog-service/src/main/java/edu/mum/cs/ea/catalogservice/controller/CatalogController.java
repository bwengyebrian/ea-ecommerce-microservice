package edu.mum.cs.ea.catalogservice.controller;

import edu.mum.cs.ea.catalogservice.dto.Product;
import edu.mum.cs.ea.catalogservice.service.feign.StockServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RefreshScope
public class CatalogController {
    @Autowired
    private StockServiceFeign stockServiceFeign;


    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${KEY1:#{null}}")
    private String key1;

    @Value("${NEXT_SERVICE:#{null}}")
    private String nextService;

    @Value("${STOCK_SERVICE_URL:#{null}}")
    private String stockServiceUrl;

    @Value("${ACCOUNT_SERVICE_URL:#{null}}")
    private String accountServiceUrl;

    @Value("${STOCK_SERVICE:#{null}}")
    private String stockService;

    //Read from secrets of k8s
    @Value("${SERVICE_API_KEY:#{null}}")
    private String apiKey;

    //private CatalogService catalogService = new CatalogServiceImpl();
    @RequestMapping("/catalog/home/products")
    List<Product> homeProducts(){
        String url = "http://" + stockServiceUrl;
        URI finalUrl = URI.create(url);
        List<Product> products = new ArrayList<>();
        return  (List<Product>) stockServiceFeign.getProducts(finalUrl).getBody();
    }
}
