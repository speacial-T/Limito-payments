package com.limito.payment.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.dto.PaymentItemDto;

public interface PaymentItemRepository {
	@Transactional
	List<PaymentItemDto> saveAll(List<PaymentItemDto> updatedProducts);

	@Transactional(readOnly = true)
	List<PaymentItemDto> getPaymentItems(UUID paymentId);
}
