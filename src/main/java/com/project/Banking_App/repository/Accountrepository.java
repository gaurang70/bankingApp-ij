package com.project.Banking_App.repository;

import com.project.Banking_App.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Accountrepository extends JpaRepository<Account,Long> {

}
