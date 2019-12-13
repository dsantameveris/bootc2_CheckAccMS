package com.everis.CheckAccMS.Service.Impl;

import com.everis.CheckAccMS.Model.CheckAccount;
import com.everis.CheckAccMS.Repository.CheckAccountRepo;
import com.everis.CheckAccMS.Service.CheckAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckAccountServiceImpl implements CheckAccountService{

    @Autowired
    private CheckAccountRepo repo;

    //Create Account
    @Override
    public Mono<CheckAccount> addAccount(CheckAccount account) {
        return repo.save(account);
    }

    //DeleteAccount
    @Override
    public Mono<Void> delAccount(CheckAccount account) {
        return repo.delete(account);
    }

    //Get All Accounts
    @Override
    public Flux<CheckAccount> findAllAccounts() {
        return repo.findAll();
    }    
}