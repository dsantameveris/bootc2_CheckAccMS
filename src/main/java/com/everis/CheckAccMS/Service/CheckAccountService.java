package com.everis.CheckAccMS.Service;

import com.everis.CheckAccMS.Model.CheckAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CheckAccountService
{
    //Create CheckAccount
    public Mono<CheckAccount> addAccount(CheckAccount account);

    //Delete Account
    public Mono<Void> delAccount(CheckAccount account);

    //Get all CheckAccounts from DB
    public Flux<CheckAccount> findAllAccounts();
}