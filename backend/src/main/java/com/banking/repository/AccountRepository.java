package com.banking.repository;

import com.banking.entity.Account;
import com.banking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Account entity
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Optional<Account> findByAccountNumber(String accountNumber);
    
    List<Account> findByUser(User user);
    
    @Query("SELECT a FROM Account a WHERE a.user = :user AND a.isActive = true")
    List<Account> findActiveAccountsByUser(@Param("user") User user);
    
    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber AND a.isActive = true")
    Optional<Account> findActiveAccountByAccountNumber(@Param("accountNumber") String accountNumber);
    
    boolean existsByAccountNumber(String accountNumber);
}