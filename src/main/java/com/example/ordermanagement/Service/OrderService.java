package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    public Order saveOrder(Order order)
    {
       return orderRepo.save(order);
    }
    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    public Order getOrderById(Long id){
        return orderRepo.findById(id).orElse(null);
    }
}
