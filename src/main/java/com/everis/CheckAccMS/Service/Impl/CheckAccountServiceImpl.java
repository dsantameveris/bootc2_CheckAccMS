package com.everis.CheckAccMS.Service.Impl;

import com.everis.CheckAccMS.Model.CheckAccount;
import com.everis.CheckAccMS.Repository.CheckAccountRepo;
import com.everis.CheckAccMS.Service.CheckAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckAccountServiceImpl implements CheckAccountService {

    @Autowired
    private CheckAccountRepo repo;

    @Override
    public Flux<CheckAccount> findAllAccounts() {
        return repo.findAll();
    }

    @Override
    public Mono<CheckAccount> findAccountByNumber(String number) {
        return repo.findByNumber(number);
    }

    @Override
    public Mono<CheckAccount> createAccount(CheckAccount account) {
        return repo.save(account);
    }

    @Override
    public Mono<Void> deleteAccount(CheckAccount account) {
        return repo.delete(account);
    }
    
}