package com.everis.CheckAccMS.Service;

import com.everis.CheckAccMS.Model.CheckAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CheckAccountService
{
    
    //Get all CheckAccounts from DB
    public Flux<CheckAccount> findAllAccounts();

    //Get account by Number
    public Mono<CheckAccount> findAccountByNumber(String number);

    //Get account by Owner
    public Mono<CheckAccount> findAccountByOwner(String owner);

    //Create CheckAccount
    public Mono<CheckAccount> addAccount(CheckAccount account);

    //Delete Account
    public Mono<Void> delAccount(CheckAccount account);

}