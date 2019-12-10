package com.everis.CheckAccount.Controller;

import com.everis.CheckAccount.Model.CheckAccount;
import com.everis.CheckAccount.Service.CheckAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CheckAccountController
{
    //Service Instance
    @Autowired
    private CheckAccountService service;

    //Get all CheckAccounts
    public Flux<CheckAccount> getAllAccounts()
    {
        return service.findAllAccounts();
    }

    //Get Account by Name
    public Mono<CheckAccount> getAccountByNumber(String number)
    {
        return service.findAccountByNumber(number);
    }

    //Create Account
    public Mono<CheckAccount> createAccount(CheckAccount account)
    {
        return service.createAccount(account);
    }

    //Delete Account
    public Mono<Void> deleteAccount(CheckAccount account)
    {
        return service.deleteAccount(account);
    }
}