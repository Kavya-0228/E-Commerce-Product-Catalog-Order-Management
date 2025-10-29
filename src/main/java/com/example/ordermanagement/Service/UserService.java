package com.example.ordermanagement.Service;
import com.example.ordermanagement.Entity.User;
import com.example.ordermanagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    public User saveUser(User user)
    {
       return userRepo.save(user);
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User getUserById(Long id){
        return userRepo.findById(id).orElse(null);
    }
}
