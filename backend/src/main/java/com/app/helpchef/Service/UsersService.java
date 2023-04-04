package com.app.helpchef.Service;

import com.app.helpchef.Model.Users;
import com.app.helpchef.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users findUserById(long userId) {
        return usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));
    }

    public Users updateUser(long userId, Users userDetails) {
        Users updateUser = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));

        updateUser.setEmail(userDetails.getEmail());
        updateUser.setName(userDetails.getName());
        updateUser.setSurname(userDetails.getSurname());
        updateUser.setNick(userDetails.getNick());

        return usersRepository.save(updateUser);
    }

    public void deleteUser(long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with ud: " + userId + " not exist"));

        usersRepository.delete(user);
    }
}
