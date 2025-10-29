package com.example.ordermanagement.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Data
public class Order {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private String status;
    private Double totalAmount;
    private String paymentId;
}
