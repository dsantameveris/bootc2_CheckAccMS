package com.everis.CheckAccMS.Service.Impl;

import com.everis.CheckAccMS.DTO.CheckAccountDTO;
import com.everis.CheckAccMS.DTO.Movement.MoneyOperationDTO;
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

    //Get All Accounts
    @Override
    public Flux<CheckAccount> findAllAccounts() {
        return repo.findAll();
    }

    //Get All Accounts (DTO)
    @Override
    public Flux<CheckAccountDTO> findAllAccountsDTO() {
        return repo.findAll().map(account -> new CheckAccountDTO(account.getNumber(), account.getCurrency()));
    }

    //Get account by Number
    @Override
    public Mono<CheckAccount> findAccountByNumber(String number) {
        return repo.findByNumber(number);
    }

    //Get account by Number (DTO)
    @Override
    public Mono<CheckAccountDTO> findAccountByNumberDTO(String number) {
        return repo.findByNumber(number).map(account -> new CheckAccountDTO(account.getNumber(), account.getCurrency()));
    }

    //Get account by Owner DNI
    @Override
    public Mono<CheckAccount> findAccountByOwnerDni(String dni) {
        return repo.findByOwner_Dni(dni);
    }

    //Get account by Owner DNI (DTO)
    @Override
    public Mono<CheckAccountDTO> findAccountByOwnerDniDTO(String dni) {
        return repo.findByOwner_Dni(dni).map(account -> new CheckAccountDTO(account.getNumber(), account.getCurrency()));
    }

    //Create Account
    @Override
    public Mono<CheckAccount> addAccount(CheckAccount account) {
        return repo.findByOwner_Dni(account.getOwner().getDni())
                                                        .switchIfEmpty(repo.save(account));
    }

    //DeleteAccount
    @Override
    public Mono<Void> delAccount(CheckAccount account) {
        return repo.delete(account);
    }

    //Deposit
    @Override
    public Mono<MoneyOperationDTO> deposit(MoneyOperationDTO deposit)
    {
        return repo.findByNumber(deposit.getMoneyDestination())
                        .flatMap(acc -> 
                        {
                            acc.setBalance(acc.getBalance() + deposit.getAmount());
                            repo.save(acc).subscribe();
                            return Mono.just(deposit);
                        });
    }
}