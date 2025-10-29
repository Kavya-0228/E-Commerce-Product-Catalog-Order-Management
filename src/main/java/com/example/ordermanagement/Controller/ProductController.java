package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.Product;
import com.example.ordermanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        Product saved = productRepo.save(product);
        return saved;
    }
    @GetMapping
    public List<Product> getAll(){
        return productRepo.findAll();
    }
}
