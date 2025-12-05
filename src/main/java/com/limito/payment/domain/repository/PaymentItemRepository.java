package com.limito.payment.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.model.PaymentItem;

public interface PaymentItemRepository {
	@Transactional
	void saveAll(List<PaymentItem> updatedProducts);

	@Transactional(readOnly = true)
	List<PaymentItem> getPaymentItems(UUID paymentId);
}
