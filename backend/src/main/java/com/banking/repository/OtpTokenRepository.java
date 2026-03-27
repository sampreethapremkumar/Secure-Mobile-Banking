package com.banking.repository;

import com.banking.entity.OtpToken;
import com.banking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for OtpToken entity
 */
@Repository
public interface OtpTokenRepository extends JpaRepository<OtpToken, Long> {
    
    Optional<OtpToken> findByOtpCodeAndOtpTypeAndIsUsedFalse(String otpCode, OtpToken.OtpType otpType);
    
    List<OtpToken> findByUserAndOtpTypeAndExpiresAtAfter(User user, OtpToken.OtpType otpType, LocalDateTime expiryDate);
    
    @Query("SELECT o FROM OtpToken o WHERE o.user = :user AND o.otpType = :otpType AND o.isUsed = false AND o.expiresAt > :now")
    List<OtpToken> findValidOtpTokensByUserAndType(@Param("user") User user, 
                                                   @Param("otpType") OtpToken.OtpType otpType, 
                                                   @Param("now") LocalDateTime now);
    
    void deleteByExpiresAtBefore(LocalDateTime expiryDate);
}