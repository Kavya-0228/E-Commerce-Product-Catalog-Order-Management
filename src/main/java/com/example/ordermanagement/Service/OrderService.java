package com.example.ordermanagement.Service;

import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Transactional
    public Order placeOrder(Order order) {
        if (order.getStatus() == null) {
            order.setStatus("PENDING");
        }
        if (order.getPaymentStatus() == null) {
            order.setPaymentStatus("PENDING");
        }
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }

    @Transactional
    public Order updateOrderStatus(Long id, String status) {
        Order existingOrder = getOrderById(id);
        if (existingOrder != null) {
            existingOrder.setStatus(status);
            
            // Update payment status based on order status
            if ("COMPLETED".equals(status)) {
                existingOrder.setPaymentStatus("PAID");
            } else if ("CANCELLED".equals(status)) {
                existingOrder.setPaymentStatus("CANCELLED");
            }
            
            return orderRepo.save(existingOrder);
        }
        return null;
    }
}
