package com.banking.dto;

import com.banking.entity.Alert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Data Transfer Object for Alert
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertDto {
    
    private Long id;
    private Long userId;
    private Long accountId;
    private Long transactionId;
    private Alert.AlertType alertType;
    private String message;
    private Alert.Severity severity;
    private Boolean isResolved;
    private Long resolvedBy;
    private LocalDateTime resolvedAt;
    private LocalDateTime createdAt;
}