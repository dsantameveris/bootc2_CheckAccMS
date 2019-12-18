package com.everis.CheckAccMS.Controller;

import com.everis.CheckAccMS.Model.CheckAccount;
import com.everis.CheckAccMS.Service.Impl.CheckAccountServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checkacc")
public class CheckAccountController
{
    //Service Instance
    @Autowired
    private CheckAccountServiceImpl service;

    
    //Get all CheckAccounts
    @GetMapping("/all")
    public Flux<CheckAccount> getAllAccounts()
    {
        return service.findAllAccounts();
    }

    //Get account By Number
    @GetMapping("/number/{number}")
    public Mono<CheckAccount> getAccountByNumber(@PathVariable String number)
    {
        return service.findAccountByNumber(number);
    }

    //Get account By owner
    @GetMapping("/owner/{owner}")
    public Mono<CheckAccount> getAccountByOwner(@PathVariable String owner)
    {
        return service.findAccountByOwner(owner);
    }

    //Create account data
    @PostMapping
    public Mono<CheckAccount> createAccount(@RequestBody CheckAccount account)
    {
        return service.addAccount(account);
    }

    //Update account data
    @PutMapping("/edit/{number}")
    public Mono<CheckAccount> editAccount(@RequestBody CheckAccount account, @PathVariable String number)
    {
        return service.findAccountByNumber(number)
                        .flatMap(ac -> 
                        {
                            ac.setCurrency(account.getCurrency());
                            return service.addAccount(ac);
                        });
    }

    //Delete account data
    @DeleteMapping("/delete/{number}")
    public Mono<Void> deleteAccountByNumber(@PathVariable String number)
    {
        return service.findAccountByNumber(number).flatMap(account -> service.delAccount(account));
    }

}