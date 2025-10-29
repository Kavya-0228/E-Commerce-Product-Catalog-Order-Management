package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.Product;
import com.example.ordermanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepo;

    @Autowired
    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
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

    public Product getProduct(Long id) {
        return getProductById(id);
    }

    public Product createProduct(Product product) {
        return saveProduct(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            product.setId(id);
            return saveProduct(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }
}
