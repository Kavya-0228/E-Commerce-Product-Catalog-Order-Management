package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.Payment;
import com.example.ordermanagement.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepo;
    public Payment savePayment(Payment payment)
    {
       return paymentRepo.save(payment);
    }
    public List<Payment> getAllPayments(){
        return paymentRepo.findAll();
    }
    public Payment getPaymentById(Long id){
        return paymentRepo.findById(id).orElse(null);
    }
}
