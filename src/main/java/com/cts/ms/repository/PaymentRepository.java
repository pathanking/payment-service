package com.cts.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.ms.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	Payment findByOrderId(int orderId);

}
