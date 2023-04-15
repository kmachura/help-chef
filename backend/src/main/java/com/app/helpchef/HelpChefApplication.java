package com.app.helpchef;

import com.app.helpchef.Model.Account;
import com.app.helpchef.Model.Users;
import com.app.helpchef.Repository.AccountRepository;
import com.app.helpchef.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class HelpChefApplication implements CommandLineRunner {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelpChefApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Users user = new Users();
        user.setEmail("johndoe@mail.com");
        user.setName("John");
        user.setSurname("Doe");
        user.setNick("jodo");

        usersRepository.save(user);

        Account account = new Account();
        account.setUser(user);
        account.setCreateDate(LocalDate.of(2023,1,1));

        accountRepository.save(account);

    }
}
