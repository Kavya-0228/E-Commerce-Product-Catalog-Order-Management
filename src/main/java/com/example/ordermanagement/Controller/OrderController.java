package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepo;
    @PostMapping
    public Order placOrder(@RequestBody Order order){
        return orderRepo.save(order);

    } 
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderRepo.findById(id) .orElse(null);
    }
    public List<Order> getAllOrders(){
            return orderRepo.findAll();
        }
    }

