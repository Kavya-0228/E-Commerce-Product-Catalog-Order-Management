package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.Product;
import com.example.ordermanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;
    public Product saveProduct(Product product)
    {
       return productRepo.save(product);
    }
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }
    public Product getProductById(Long id){
        return productRepo.findById(id).orElse(null);
    }
}
