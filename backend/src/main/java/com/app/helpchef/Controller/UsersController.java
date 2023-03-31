package com.app.helpchef.Controller;

import com.app.helpchef.Model.Users;
import com.app.helpchef.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersRepository.save(user);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));
        return ResponseEntity.ok(user);
    }

    @PutMapping("editUser/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable long userId, @RequestBody Users userDetails) {
        Users updateUser = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));

        updateUser.setEmail(userDetails.getEmail());
        updateUser.setName(userDetails.getName());
        updateUser.setSurname(userDetails.getSurname());
        updateUser.setNick(userDetails.getNick());

        usersRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));

        usersRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
