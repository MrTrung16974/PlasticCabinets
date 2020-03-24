package com.example.plasticcabinets.controller;

import com.example.plasticcabinets.exception.ResurceNotFoundException;
import com.example.plasticcabinets.model.Products;
import com.example.plasticcabinets.model.Users;
import com.example.plasticcabinets.repository.ProductsRepository;
import com.example.plasticcabinets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api")
public class UserApiController {
    @Autowired
    UserRepository userRepository;

    //    Get all Product
    @GetMapping("/user")
    public List<Users> getAllProduct() {
        return userRepository.findAll();
    }

    // Create a product
    @PostMapping("/user")
    public Users createProduct(@Valid @RequestBody Users product) {
        return userRepository.save(product);
    }

    //    Get a single product
    @GetMapping("/user/{id}")
    public Users getProductById(@PathVariable(value = "id") Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResurceNotFoundException("User", "id", userId));
    }

    //    update a product
    @PutMapping("/user/{id}")
    public Users updateProduct(@Valid @PathVariable(value = "id") Integer userId, @Valid @RequestBody Users userDetail) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new ResurceNotFoundException("User", "id", userId));
        user.setAccount(userDetail.getAccount());
        Users updateUser = userRepository.save(user);
        return updateUser;
    }

    //    Delete a product
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Integer userId) {
        Users user = userRepository.findById(userId).orElseThrow(() ->
                new ResurceNotFoundException("User", "id", userId));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
