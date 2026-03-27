package com.banking.controller;

import com.banking.dto.TransactionDto;
import com.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Transaction Controller
 */
@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;
    
    @GetMapping
    public ResponseEntity<List<TransactionDto>> getUserTransactions() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        // TODO: Get user ID from username
        List<TransactionDto> transactions = transactionService.getTransactionsByUserId(1L); // Temporary
        return ResponseEntity.ok(transactions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        TransactionDto transactionDto = transactionService.getTransactionById(id);
        return ResponseEntity.ok(transactionDto);
    }
    
    @PostMapping("/transfer")
    public ResponseEntity<TransactionDto> transferMoney(@RequestBody TransactionDto transactionDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        // TODO: Get user ID from username
        TransactionDto transferResult = transactionService.transferMoney(1L, transactionDto); // Temporary
        return ResponseEntity.ok(transferResult);
    }
    
    @PutMapping("/{id}/flag")
    public ResponseEntity<Void> flagTransaction(@PathVariable Long id, @RequestParam String reason) {
        transactionService.flagTransaction(id, reason);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}/approve")
    public ResponseEntity<Void> approveTransaction(@PathVariable Long id) {
        transactionService.approveTransaction(id);
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}/reject")
    public ResponseEntity<Void> rejectTransaction(@PathVariable Long id) {
        transactionService.rejectTransaction(id);
        return ResponseEntity.ok().build();
    }
}