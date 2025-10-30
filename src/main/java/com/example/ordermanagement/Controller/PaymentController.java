package com.example.ordermanagement.Controller;

import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class PaymentController {
    
    @Autowired
    private OrderRepository orderRepo;
    
    @PostMapping("/{id}/payment")
    public ResponseEntity<Order> processPayment(@PathVariable Long id, @RequestBody Map<String, String> payment) {
        return orderRepo.findById(id)
            .map(order -> {
                order.setPaymentId(payment.get("paymentId"));
                order.setPaymentStatus("PAID");
                return ResponseEntity.ok(orderRepo.save(order));
            })
            .orElse(ResponseEntity.notFound().build());
    }
}