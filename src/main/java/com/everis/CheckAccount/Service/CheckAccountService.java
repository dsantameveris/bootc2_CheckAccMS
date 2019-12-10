package com.everis.CheckAccount.Service;

import com.everis.CheckAccount.Model.CheckAccount;
import com.everis.CheckAccount.Repository.CheckAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckAccountService implements CheckAccountInterface {

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