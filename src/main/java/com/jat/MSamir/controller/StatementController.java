package com.jat.MSamir.controller;

import com.jat.MSamir.dao.AccountRepository;
import com.jat.MSamir.dao.StatementRepository;
import com.jat.MSamir.dao.UserRepository;
import com.jat.MSamir.domain.Account;
import com.jat.MSamir.domain.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/statements")
public class StatementController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatementRepository statementRepository;

    @PostMapping(value = "/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Statement addStatement(@RequestBody Statement statement,@PathVariable Long accountId) {
        Optional<Account> byId = accountRepository.findById(accountId);
        Account account = byId.get();
        statement.setAccount(account);
        statement.mapAccount();
        account.addStatement(statement);
        return statementRepository.save(statement);
    }
}