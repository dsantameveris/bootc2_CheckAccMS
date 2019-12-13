package com.everis.CheckAccMS.Repository;

import com.everis.CheckAccMS.Model.CheckAccount;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CheckAccountRepo extends ReactiveMongoRepository<CheckAccount, String>
{

}