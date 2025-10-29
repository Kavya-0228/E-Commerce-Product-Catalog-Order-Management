package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Repository.OrderRepository;
import com.example.ordermanagement.Entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {
    @Autowired
    private OrderRepository orderRepo;
    @GetMapping("/sales-report")
    public Map<String,Object> getSalesReport(){
    List<Order> orders = orderRepo.findByStatus("DELIVERED");
    double totalSales = orders.stream().mapToDouble(Order::getTotalAmount).sum();
        Map<String,Object> report = new HashMap<>();
        report.put("totalSales",totalSales);
        report.put("orderCount",orders.size());
        return report;
    }
}
