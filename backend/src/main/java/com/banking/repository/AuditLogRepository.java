package com.banking.repository;

import com.banking.entity.AuditLog;
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
 * Repository interface for AuditLog entity
 */
@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    
    List<AuditLog> findByUserOrderByCreatedAtDesc(User user);
    
    Page<AuditLog> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
    
    @Query("SELECT a FROM AuditLog a WHERE a.createdAt >= :startDate AND a.createdAt <= :endDate ORDER BY a.createdAt DESC")
    List<AuditLog> findAuditLogsByDateRange(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
    
    @Query("SELECT a FROM AuditLog a WHERE a.user = :user AND a.action = :action ORDER BY a.createdAt DESC")
    List<AuditLog> findAuditLogsByUserAndAction(@Param("user") User user, @Param("action") String action);
    
    @Query("SELECT COUNT(a) FROM AuditLog a WHERE a.user = :user AND a.createdAt >= :startTime")
    long countAuditLogsByUserAndTimeWindow(@Param("user") User user, @Param("startTime") LocalDateTime startTime);
}