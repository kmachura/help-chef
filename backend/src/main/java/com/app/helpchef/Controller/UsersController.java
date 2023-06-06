package com.app.helpchef.Controller;

import com.app.helpchef.Model.Users;
import com.app.helpchef.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable long userId) {
        return ResponseEntity.ok(usersService.findUserById(userId));
    }

    @PutMapping("/editUser/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable long userId, @RequestBody Users userDetails) {
        return ResponseEntity.ok(usersService.updateUser(userId, userDetails));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long userId) {
        usersService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
