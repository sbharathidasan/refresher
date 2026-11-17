package com.spring.ecommerce.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ecommerce.model.Product;
import com.spring.ecommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/{id}")
    public Product getProductDetails( @PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }
    // @PostMapping("/cart/add")
    // public String productCart(@RequestParam Long productId,@RequestParam int quantity){
    //     return "Product id "+productId+"had been added to your cart with quantity:"+quantity;
    // }
    // @PostMapping("/buy-now")
    // public String productBuy(@RequestParam Long productId,@RequestParam int quantity){
    //     return "Direct checkout initiated for Product ID:"+productId+" with Quantity "+quantity;
    // }
    // @PutMapping(/{id})
    // public Product update(@PathVariable Long id){
    //     return productRepository.FindById(id).orElse(null);
    // }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
