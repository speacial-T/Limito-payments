package com.limito.payment.domain.repository;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.model.Payment;

public interface PaymentRepository {
	@Transactional()
	Payment getByOrderId(UUID orderId);

	@Transactional()
	Payment savePayment(Payment p);
}
