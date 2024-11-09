package com.project.Banking_App.controller;

import com.project.Banking_App.dto.AccountDto;
import com.project.Banking_App.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/accounts")
@RestController
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService=accountService;

    }
//    ADD Account REST-Api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

//    Get Account REST-Api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable  Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return  ResponseEntity.ok(accountDto);
    }

    //Deposit REST-Api

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double>request){
        Double amount =request.get("amount");
            AccountDto accountDto= accountService.deposit(id,amount).getBody();
            return   ResponseEntity.ok(accountDto);
    }

//withdraw REST-Api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double>request){
        Double amount =request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return   ResponseEntity.ok(accountDto);
    }

//    GetAllAccounts REST-Api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccounts();
        return  ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return  ResponseEntity.ok("Account deleted successfully");
    }

}
