package com.example.ordermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.ordermanagement.Repository.ProductRepository;
import com.example.ordermanagement.Repository.OrderRepository;

@Controller
public class ViewController {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private OrderRepository orderRepo;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products";
    }

    @GetMapping("/orders")
    public String ordersPage(Model model) {
        model.addAttribute("orders", orderRepo.findAll());
        return "orders";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}