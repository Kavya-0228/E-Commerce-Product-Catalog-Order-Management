package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import com.example.ordermanagement.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        logger.info("Received order placement request: {}", order);
        try {
            Order savedOrder = orderService.placeOrder(order);
            logger.info("Order placed successfully: {}", savedOrder);
            return ResponseEntity.ok(savedOrder);
        } catch (Exception e) {
            logger.error("Error placing order: {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        logger.info("Fetching order with id: {}", id);
        return orderRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Order> getAllOrders() {
        logger.info("Fetching all orders");
        return orderRepo.findAll();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestBody OrderStatusUpdate update) {
        logger.info("Updating order {} status to: {}", id, update.getStatus());
        try {
            Order updatedOrder = orderService.updateOrderStatus(id, update.getStatus());
            return ResponseEntity.ok(updatedOrder);
        } catch (Exception e) {
            logger.error("Error updating order status: {}", e.getMessage(), e);
            return ResponseEntity.badRequest().build();
        }
    }
}

class OrderStatusUpdate {
    private String status;
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}

