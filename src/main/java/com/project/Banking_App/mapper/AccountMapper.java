package com.project.Banking_App.mapper;

import com.project.Banking_App.dto.AccountDto;
import com.project.Banking_App.entity.Account;

public class AccountMapper {
    public static Account mapAccount(AccountDto accountDto){
            Account account= new Account(
                    accountDto.getId(),
                    accountDto.getAccountHolderName(),
                    accountDto.getBalance()
            );
            return account;
    }

    public static AccountDto mapAccountDto(Account account) {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}

