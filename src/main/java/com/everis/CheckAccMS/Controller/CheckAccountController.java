package com.everis.CheckAccMS.Controller;

import com.everis.CheckAccMS.Model.CheckAccount;
import com.everis.CheckAccMS.Service.Impl.CheckAccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CheckAccountController
{
    //Service Instance
    @Autowired
    private CheckAccountServiceImpl service;

    //Create Account
    @PostMapping("/checkacc/create")
    public Mono<CheckAccount> createAccount(CheckAccount account)
    {
        return service.addAccount(account);
    }

    //Delete Account
    @DeleteMapping("/checkacc/delete")
    public Mono<Void> deleteAccount(CheckAccount account)
    {
        return service.delAccount(account);
    }

    //Get all CheckAccounts
    @GetMapping("/checkacc/all")
    public Flux<CheckAccount> getAllAccounts()
    {
        return service.findAllAccounts();
    }
}