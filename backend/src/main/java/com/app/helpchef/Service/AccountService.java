package com.app.helpchef.Service;

import com.app.helpchef.Model.Account;
import com.app.helpchef.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findAccountById(long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account with id: " + accountId + " not exist"));
    }

    public Account updateAccount(long accountId, Account accountDetails) {
        Account updateAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Acccount with id: " + accountId + " not exist"));

        updateAccount.setCreateDate(accountDetails.getCreateDate());
        updateAccount.setUser(accountDetails.getUser());

        return accountRepository.save(updateAccount);
    }

    public void deleteAccount(long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account with id: " + accountId + " not exist"));

        accountRepository.delete(account);
    }
}
