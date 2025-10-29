package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.Order;
import com.example.ordermanagement.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class AnalyticsService {
    @Autowired
    private OrderRepository orderRepo;
    public Map<String,Object> getSalesReport(){
        List<Order> delivered = orderRepo.findByStatus("DELIVERED");
        double totalSales = delivered.stream().mapToDouble(Order::getTotalAmount).sum();
        Map<String,Object> report = new HashMap<>();
        report.put("totalSales",totalSales);
        report.put("orderCount",delivered.size());
        return report;
    
    }
}
