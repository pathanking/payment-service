package com.cts.ms.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ms.entity.Payment;
import com.cts.ms.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public Payment doPayment(Payment payment) {
		payment.setPaymentStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		return paymentRepository.save(payment);
	}

	public String paymentProcessing() {
		// 3rd party payment gateway(paypal, paytm, billdesk etc..) should return payment status
		return new Random().nextBoolean() ? "success" : "false";
	}

	public Payment findPaymentByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return paymentRepository.findByOrderId(orderId);
	}

}
