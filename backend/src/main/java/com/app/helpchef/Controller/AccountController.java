package com.app.helpchef.Controller;

import com.app.helpchef.Model.Account;
import com.app.helpchef.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@SuppressWarnings("unused")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping
    public List<Account> getAllUsers() {
        return accountService.findAll();
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable long accountId) {
        return ResponseEntity.ok(accountService.findAccountById(accountId));
    }

    @PutMapping("/editAccount/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable long accountId, @RequestBody Account accountDetails) {
        return ResponseEntity.ok(accountService.updateAccount(accountId, accountDetails));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
