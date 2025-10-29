package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.Payment;
import com.example.ordermanagement.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/paments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepo;
    @PostMapping
    public Payment recordPayment(@RequestBody Payment payment){
        return paymentRepo.save(payment);
    }
}
