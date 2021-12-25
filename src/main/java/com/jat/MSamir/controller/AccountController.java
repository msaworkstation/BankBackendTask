package com.jat.MSamir.controller;

import com.jat.MSamir.dao.AccountRepository;
import com.jat.MSamir.dao.StatementRepository;
import com.jat.MSamir.dao.UserRepository;
import com.jat.MSamir.domain.Account;
import com.jat.MSamir.domain.Statement;
import com.jat.MSamir.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/accounts")

public class AccountController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatementRepository statementRepository;

    @GetMapping("/{userId}")
    public @ResponseBody Set<Account> getAccounts(@PathVariable Long userId) {
        Optional<User> byId = userRepository.findById(userId);
        //TODO add or else
        return byId.get().getAccounts();
    }

    @PostMapping(value = "/statements")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Set<Statement> getStatment(@RequestBody Map<String, Long> userMap) {
        return accountRepository.findById(userMap.get("id")).get().getStatementList();
    }

    @PostMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Account addUser(@RequestBody Account account,@PathVariable Long userId) {
        User user = userRepository.findById(userId).get();
        user.addAccount(account);
        account.setUser(user);
        return accountRepository.save(account);
    }
}