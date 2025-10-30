package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.Product;
import com.example.ordermanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        logger.info("Received request to save product: {}", product);
        Product saved = productRepo.save(product);
        logger.info("Saved product: {}", saved);
        return saved;
    }
    
    @GetMapping
    public List<Product> getAll(){
        return productRepo.findAll();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        logger.info("Deleting product with id: {}", id);
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
