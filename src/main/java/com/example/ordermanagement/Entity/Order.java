package com.example.ordermanagement.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity

@Data
public class Order {
    @Id 
    @GeneratedValue
    private Long id;
    private Long userId;
    private String status;
    private Double totalAmount;
    private String paymentId;
}
