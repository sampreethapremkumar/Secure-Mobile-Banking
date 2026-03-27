package com.banking.repository;

import com.banking.entity.Alert;
import com.banking.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Alert entity
 */
@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    
    List<Alert> findByUserOrderByCreatedAtDesc(User user);
    
    Page<Alert> findByUserOrderByCreatedAtDesc(User user, Pageable pageable);
    
    @Query("SELECT a FROM Alert a WHERE a.isResolved = false ORDER BY a.createdAt DESC")
    List<Alert> findUnresolvedAlerts();
    
    @Query("SELECT a FROM Alert a WHERE a.isResolved = false AND a.severity IN ('HIGH', 'CRITICAL') ORDER BY a.createdAt DESC")
    List<Alert> findHighPriorityAlerts();
    
    @Query("SELECT COUNT(a) FROM Alert a WHERE a.user = :user AND a.isResolved = false")
    long countUnresolvedAlertsByUser(@Param("user") User user);
}