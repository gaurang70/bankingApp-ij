package com.project.Banking_App.service;

import com.project.Banking_App.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
//    AccountDto deposit(Long id,double amount);
    ResponseEntity<AccountDto> deposit(Long id, double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);



}
//*++**********************************************

