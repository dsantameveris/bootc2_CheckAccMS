package com.everis.CheckAccMS.Repository;

import com.everis.CheckAccMS.Model.CheckAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;

public interface CheckAccountRepo extends ReactiveMongoRepository<CheckAccount, String>
{
    //Get account by number
    public Mono<CheckAccount> findByNumber(String Number);
}