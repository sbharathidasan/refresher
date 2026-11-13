package com.spring.ecommerce.controller;
import com.spring.ecommerce.model.Product;
import com.spring.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    // @GetMapping("/{id}")
    // public Product getProductDetails( @PathVariable Long id){
    //     Product pd=new Product(id,"wireless headphone",788,14);
    //     System.out.println(pd.getName());
    //     return pd;
    // }
    // @PostMapping("/cart/add")
    // public String productCart(@RequestParam Long productId,@RequestParam int quantity){
    //     return "Product id "+productId+"had been added to your cart with quantity:"+quantity;
    // }
    // @PostMapping("/buy-now")
    // public String productBuy(@RequestParam Long productId,@RequestParam int quantity){
    //     return "Direct checkout initiated for Product ID:"+productId+" with Quantity "+quantity;
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
