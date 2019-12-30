package com.everis.CheckAccMS.Service;

import com.everis.CheckAccMS.DTO.CheckAccountDTO;
import com.everis.CheckAccMS.DTO.Movement.MoneyOperationDTO;
import com.everis.CheckAccMS.Model.CheckAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CheckAccountService
{
    
    //Get all CheckAccounts from DB
    public Flux<CheckAccount> findAllAccounts();

    //Get all CheckAccounts (DTO)
    public Flux<CheckAccountDTO> findAllAccountsDTO();

    //Get account by Number
    public Mono<CheckAccount> findAccountByNumber(String number);

    //Get account by Number (DTO)
    public Mono<CheckAccountDTO> findAccountByNumberDTO(String number);

    //Get account by Owner DNI
    public Mono<CheckAccount> findAccountByOwnerDni(String dni);

    //Get account by Owner DNI (DTO)
    public Mono<CheckAccountDTO> findAccountByOwnerDniDTO(String dni);

    //Create CheckAccount
    public Mono<CheckAccount> addAccount(CheckAccount account);

    //Delete Account
    public Mono<Void> delAccount(CheckAccount account);

    //Deposit
    public Mono<MoneyOperationDTO> deposit(MoneyOperationDTO deposit);

}