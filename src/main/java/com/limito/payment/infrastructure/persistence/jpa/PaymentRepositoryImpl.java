package com.limito.payment.infrastructure.persistence.jpa;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.dto.PaymentDto;
import com.limito.payment.domain.model.PaymentEntity;
import com.limito.payment.domain.model.PaymentMapper;
import com.limito.payment.domain.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
	private final PaymentJpaRepository paymentJpaRepository;
	private final PaymentMapper mapper;

	@Transactional(readOnly = true)
	@Override
	public PaymentDto getByOrderId(UUID orderId) {
		PaymentEntity paymentEntity = paymentJpaRepository.findByOrderIdAndDeletedAtIsNull(orderId)
			.orElseThrow(() -> new IllegalArgumentException("Payment not found for orderId: " + orderId));
		return mapper.toDomain(paymentEntity);
	}

	@Transactional()
	@Override
	public PaymentDto save(PaymentEntity payment) {
		PaymentEntity saved = paymentJpaRepository.save(payment);
		return mapper.toDomain(saved);
	}

	public PaymentDto findById(UUID paymentId) {
		PaymentEntity paymentEntity = paymentJpaRepository.findById(paymentId)
			.orElseThrow(() -> new IllegalArgumentException("Payment not found for paymentId: " + paymentId));
		return mapper.toDomain(paymentEntity);
	}

	@Override
	public boolean existsByOrderId(UUID orderId) {
		return paymentJpaRepository.existsByOrderIdAndDeletedAtIsNull(orderId);
	}

	@Override
	public void flush() {
		paymentJpaRepository.flush();
	}
}
