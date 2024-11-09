package com.project.Banking_App.service.implementation;

import com.project.Banking_App.dto.AccountDto;
import com.project.Banking_App.entity.Account;
import com.project.Banking_App.mapper.AccountMapper;
import com.project.Banking_App.repository.Accountrepository;
import com.project.Banking_App.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountserviceImplementaion implements AccountService {

    private Accountrepository accountrepository;

    public AccountserviceImplementaion(Accountrepository accountrepository) {
        this.accountrepository = accountrepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapAccount(accountDto);
       Account savedAccount= accountrepository.save(account);
        return AccountMapper.mapAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account
                =accountrepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));

        return AccountMapper.mapAccountDto(account);
    }


@Override
public ResponseEntity<AccountDto> deposit(Long id, double amount) {
    // Check if the amount is valid (greater than zero)
    if (amount <= 0) {
        return ResponseEntity.badRequest().body(null); // Return 400 Bad Request for invalid amount
    }

    // Find the account by ID
    Account account = accountrepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Account does not exist"));

    // Update the account balance
    double totalBalance = account.getBalance() + amount;
    account.setBalance(totalBalance);

    // Save the updated account
    Account savedAccount = accountrepository.save(account);

    // Return the updated account information with a 200 OK status
    return ResponseEntity.ok(AccountMapper.mapAccountDto(savedAccount));
}

    @Override
    public AccountDto withdraw(Long id, double amount) {

        Account account =accountrepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));

        if(account.getBalance()<amount){
            throw new RuntimeException("OOPS... !! Insufficient balance");
        }


        double totalBalance = account.getBalance() - amount;
        account.setBalance(totalBalance);
        Account savedAccount=accountrepository.save(account);
        return AccountMapper.mapAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountrepository.findAll();
    return    accounts.stream().map(account -> AccountMapper.mapAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account
                =accountrepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        accountrepository.deleteById(id);

    }
}
//***************************************************************************************************

