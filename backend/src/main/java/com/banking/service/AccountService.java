package com.banking.service;

import com.banking.dto.AccountDto;
import com.banking.entity.Account;

import java.util.List;

/**
 * Account Service interface
 */
public interface AccountService {
    
    AccountDto createAccount(Long userId, AccountDto accountDto);
    
    AccountDto getAccountById(Long id);
    
    List<AccountDto> getAccountsByUserId(Long userId);
    
    AccountDto updateAccount(Long id, AccountDto accountDto);
    
    void deleteAccount(Long id);
    
    Account findAccountEntityById(Long id);
    
    Account findAccountEntityByNumber(String accountNumber);
    
    void creditAccount(Long accountId, Double amount);
    
    void debitAccount(Long accountId, Double amount);
}