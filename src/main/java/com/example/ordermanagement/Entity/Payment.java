package com.example.ordermanagement.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.Data;
@Entity
@Data
public class Payment {
    @Id @GeneratedValue
    private Long id;
    private Long orderId;
    private String method;
    private String status;
    private String transactionId;
    

}
