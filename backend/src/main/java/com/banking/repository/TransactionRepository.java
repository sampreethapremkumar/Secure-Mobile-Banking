package com.banking.repository;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for Transaction entity
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    List<Transaction> findByUserOrderByCreatedAtDesc(User user);
    
    Page<Transaction> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
    
    List<Transaction> findByFromAccountOrToAccountOrderByCreatedAtDesc(Account fromAccount, Account toAccount);
    
    @Query("SELECT t FROM Transaction t WHERE t.user = :user AND t.createdAt >= :startDate AND t.createdAt <= :endDate ORDER BY t.createdAt DESC")
    List<Transaction> findTransactionsByUserAndDateRange(@Param("user") User user, 
                                                         @Param("startDate") LocalDateTime startDate, 
                                                         @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT t FROM Transaction t WHERE t.status = 'FLAGGED' ORDER BY t.createdAt DESC")
    List<Transaction> findFlaggedTransactions();
    
    @Query("SELECT COUNT(t) FROM Transaction t WHERE t.fromAccount = :account AND t.createdAt >= :startTime")
    long countTransactionsByAccountAndTimeWindow(@Param("account") Account account, @Param("startTime") LocalDateTime startTime);
    
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.fromAccount = :account AND t.createdAt >= :startTime")
    Double sumTransactionAmountsByAccountAndTimeWindow(@Param("account") Account account, @Param("startTime") LocalDateTime startTime);
}