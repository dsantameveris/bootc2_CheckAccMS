package com.everis.CheckAccMS.Service;

import com.everis.CheckAccMS.Model.CheckAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CheckAccountService
{
    //Get all CheckAccounts from DB
    public Flux<CheckAccount> findAllAccounts();

    //Get CheckAccount by number
    public Mono<CheckAccount> findAccountByNumber(String number);

    //Create CheckAccount
    public Mono<CheckAccount> createAccount(CheckAccount account);

    //Delete Account by number
    public Mono<Void> deleteAccount(CheckAccount account);

}