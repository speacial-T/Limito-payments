package com.limito.payment.infrastructure.persistence.jpa;

import static com.limito.payment.domain.model.Payment.*;
import static com.limito.payment.infrastructure.persistence.entity.PaymentEntity.*;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.model.Payment;
import com.limito.payment.domain.repository.PaymentRepository;
import com.limito.payment.infrastructure.persistence.entity.PaymentEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
	private final PaymentJpaRepository paymentJpaRepository;

	@Transactional(readOnly = true)
	@Override
	public Payment getByOrderId(UUID orderId) {
		PaymentEntity paymentEntity = paymentJpaRepository.findByOrderId(orderId)
			.orElseThrow(() -> new IllegalArgumentException("Payment not found for orderId: " + orderId));

		return toDomain(paymentEntity);
	}

	@Transactional()
	@Override
	public Payment savePayment(Payment p) {
		PaymentEntity paymentEntity = toEntity(p);
		paymentEntity = paymentJpaRepository.save(paymentEntity);
		return toDomain(paymentEntity);
	}
}
