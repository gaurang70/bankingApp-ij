package com.project.Banking_App.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.annotation.Id;


//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
    public Account(Long id, String accountHolderName, double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
    public Account(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_holder_name")
    private String accountHolderName;

    private double balance;



    public void setId(Long id) {
        this.id = id;
    }
//
    public void setBalance(double balance) {
        this.balance = balance;
    }


//
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
//
    public double getBalance() {
        return balance;
    }
//
    public Long getId() {
        return id;
    }
}
//*******************************************************************

