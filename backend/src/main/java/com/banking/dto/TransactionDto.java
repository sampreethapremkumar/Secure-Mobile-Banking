package com.banking.dto;

import com.banking.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data Transfer Object for Transaction
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    
    private Long id;
    private Long fromAccountId;
    private Long toAccountId;
    private Transaction.TransactionType transactionType;
    private BigDecimal amount;
    private String description;
    private Transaction.TransactionStatus status;
    private String referenceNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.fromAccountId = transaction.getFromAccount() != null ? transaction.getFromAccount().getId() : null;
        this.toAccountId = transaction.getToAccount() != null ? transaction.getToAccount().getId() : null;
        this.transactionType = transaction.getTransactionType();
        this.amount = transaction.getAmount();
        this.description = transaction.getDescription();
        this.status = transaction.getStatus();
        this.referenceNumber = transaction.getReferenceNumber();
        this.createdAt = transaction.getCreatedAt();
        this.updatedAt = transaction.getUpdatedAt();
    }
}