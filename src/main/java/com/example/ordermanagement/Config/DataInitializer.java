package com.example.ordermanagement.Config;

import com.example.ordermanagement.Entity.Product;
import com.example.ordermanagement.Entity.User;
import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.ProductRepository;
import com.example.ordermanagement.Repository.UserRepository;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private OrderRepository orderRepo;

    @Override
    public void run(String... args) throws Exception {
        // Add sample products
        if (productRepo.count() == 0) {
            Product p1 = new Product();
            p1.setName("Laptop");
            p1.setDescription("High-performance laptop");
            p1.setPrice(999.99);
            p1.setStock(10);
            productRepo.save(p1);

            Product p2 = new Product();
            p2.setName("Mouse");
            p2.setDescription("Wireless optical mouse");
            p2.setPrice(29.99);
            p2.setStock(50);
            productRepo.save(p2);

            Product p3 = new Product();
            p3.setName("Keyboard");
            p3.setDescription("Mechanical keyboard");
            p3.setPrice(79.99);
            p3.setStock(25);
            productRepo.save(p3);

            Product p4 = new Product();
            p4.setName("Monitor");
            p4.setDescription("24-inch LED monitor");
            p4.setPrice(199.99);
            p4.setStock(8);
            productRepo.save(p4);

            Product p5 = new Product();
            p5.setName("Headphones");
            p5.setDescription("Noise-canceling headphones");
            p5.setPrice(149.99);
            p5.setStock(15);
            productRepo.save(p5);
        }
        
        // Add sample users
        if (userRepo.count() == 0) {
            User u1 = new User();
            u1.setUsername("kaviee");
            u1.setName("Kaviee");
            u1.setEmail("kaviee@example.com");
            u1.setRole("CUSTOMER");
            userRepo.save(u1);
            
            User u2 = new User();
            u2.setUsername("deepi");
            u2.setName("Deepi");
            u2.setEmail("deepi@example.com");
            u2.setRole("CUSTOMER");
            userRepo.save(u2);
            
            User u3 = new User();
            u3.setUsername("pavi");
            u3.setName("Pavi");
            u3.setEmail("pavi@example.com");
            u3.setRole("CUSTOMER");
            userRepo.save(u3);
        }
        
        // Add sample orders
        if (orderRepo.count() == 0) {
            User user1 = userRepo.findAll().get(0);
            User user2 = userRepo.findAll().get(1);
            User user3 = userRepo.findAll().get(2);
            
            Order o1 = new Order();
            o1.setUser(user1);
            o1.setStatus("PENDING");
            o1.setTotalAmount(1029.98);
            o1.setPaymentStatus("PENDING");
            o1.setOrderDate(LocalDateTime.now().minusDays(2));
            orderRepo.save(o1);
            
            Order o2 = new Order();
            o2.setUser(user2);
            o2.setStatus("DELIVERED");
            o2.setTotalAmount(229.98);
            o2.setPaymentId("PAY_123456");
            o2.setPaymentStatus("PAID");
            o2.setOrderDate(LocalDateTime.now().minusDays(5));
            orderRepo.save(o2);
            
            Order o3 = new Order();
            o3.setUser(user3);
            o3.setStatus("PENDING");
            o3.setTotalAmount(79.99);
            o3.setPaymentStatus("PENDING");
            o3.setOrderDate(LocalDateTime.now().minusDays(1));
            orderRepo.save(o3);
            
            Order o4 = new Order();
            o4.setUser(user1);
            o4.setStatus("DELIVERED");
            o4.setTotalAmount(349.98);
            o4.setPaymentId("PAY_789012");
            o4.setPaymentStatus("PAID");
            o4.setOrderDate(LocalDateTime.now().minusDays(7));
            orderRepo.save(o4);
        }
    }
}