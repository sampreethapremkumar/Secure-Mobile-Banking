package com.banking.service;

import com.banking.dto.TransactionDto;
import com.banking.entity.Transaction;

import java.util.List;

/**
 * Transaction Service interface
 */
public interface TransactionService {
    
    TransactionDto transferMoney(Long userId, TransactionDto transactionDto);
    
    TransactionDto getTransactionById(Long id);
    
    List<TransactionDto> getTransactionsByUserId(Long userId);
    
    List<TransactionDto> getTransactionsByAccountId(Long accountId);
    
    void flagTransaction(Long transactionId, String reason);
    
    void approveTransaction(Long transactionId);
    
    void rejectTransaction(Long transactionId);
    
    Transaction findTransactionEntityById(Long id);
}