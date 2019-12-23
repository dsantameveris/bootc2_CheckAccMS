package com.everis.CheckAccMS.Repository;

import com.everis.CheckAccMS.Model.CheckAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface CheckAccountRepo extends ReactiveMongoRepository<CheckAccount, String>
{
    Mono<CheckAccount> findByNumber(String number);
    
    Mono<CheckAccount> findByOwner_Dni(String dni);
}