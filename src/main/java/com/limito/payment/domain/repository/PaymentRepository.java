package com.limito.payment.domain.repository;

import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.dto.PaymentDto;
import com.limito.payment.domain.model.PaymentEntity;

public interface PaymentRepository {
	@Transactional()
	PaymentDto getByOrderId(UUID orderId);

	@Transactional()
	PaymentDto save(PaymentEntity payment);

	@Transactional(readOnly = true)
	boolean existsByOrderId(UUID orderId);

	void flush();
}
