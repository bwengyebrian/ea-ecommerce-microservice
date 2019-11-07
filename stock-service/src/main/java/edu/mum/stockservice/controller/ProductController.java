package edu.mum.stockservice.controller;

import edu.mum.stockservice.model.Product;
import edu.mum.stockservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

//    @GetMapping("/product/{id}")
//    public String getPrduct(@PathVariable("id") int id){
//
//        return "Chama " +id;
//    }

    @GetMapping("/{id}/detail")
    public Product getProduct(@PathVariable("id") int id){

        return productService.fetchProdut(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.fetchAllProducts();
    }

    @GetMapping("/{id}/availableItems")
    public Integer getNumberOfProductInTheStock(@PathVariable("id") int id){
        return productService.fetchProdut(id).getAvailableItems();
    }

}
