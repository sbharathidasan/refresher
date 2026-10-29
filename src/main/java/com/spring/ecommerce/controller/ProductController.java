package com.spring.ecommerce.controller;
import com.spring.ecommerce.model.Product;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("api/products")
public class ProductController {
    @GetMapping("/{id}")
    public Product getProductDetails( @PathVariable Long id){
        Product pd=new Product(id,"wireless headphone",788,14);
        System.out.println(pd.getName());
        return pd;
    }
    @PostMapping("/cart/add")
    public String productCart(@RequestParam Long productId,@RequestParam int quantity){
        return "Product id "+productId+"had been added to your cart with quantity:"+quantity;
    }
    @PostMapping("/buy-now")
    public String productBuy(@RequestParam Long productId,@RequestParam int quantity){
        return "Direct checkout initiated for Product ID:"+productId+" with Quantity "+quantity;
    }
}
