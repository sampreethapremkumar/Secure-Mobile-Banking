package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Transfer Request DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {
    
    @NotBlank
    private String fromAccountNumber;
    
    @NotBlank
    private String toAccountNumber;
    
    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount;
    
    private String description;
    
    @NotBlank
    private String otpCode;
}