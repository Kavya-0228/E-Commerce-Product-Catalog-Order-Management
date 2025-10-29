package com.example.ordermanagement.Controller;
import com.example.ordermanagement.Entity.User;
import com.example.ordermanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")

public class AuthController {
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userRepo.save(user));

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.of(userRepo.findById(id));
    }
}
