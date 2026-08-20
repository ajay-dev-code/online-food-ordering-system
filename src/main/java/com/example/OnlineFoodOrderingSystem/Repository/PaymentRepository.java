package com.example.OnlineFoodOrderingSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineFoodOrderingSystem.Entity.Payment;
import com.example.OnlineFoodOrderingSystem.Entity.PaymentStatus;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	List<Payment> findByPaymentStatus(PaymentStatus status);
	
	
}
