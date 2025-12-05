package com.limito.payment.infrastructure.persistence.jpa;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.model.PaymentItem;
import com.limito.payment.domain.repository.PaymentItemRepository;
import com.limito.payment.infrastructure.persistence.entity.PaymentItemEntity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PaymentItemRepositoryImpl implements PaymentItemRepository {

	private final PaymentItemJpaRepository paymentItemJpaRepository;

	@Transactional
	@Override
	public void saveAll(List<PaymentItem> orderItems) {
		List<PaymentItemEntity> entities = orderItems.stream()
			.map(PaymentItem::toEntity)
			.collect(Collectors.toList());

		paymentItemJpaRepository.saveAll(entities);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PaymentItem> getPaymentItems(UUID paymentId) {
		List<PaymentItemEntity> paymentItems = paymentItemJpaRepository.findAllByPaymentPaymentId(paymentId);

		if (paymentItems.isEmpty()) {
			throw new IllegalArgumentException("No payment items found for paymentId: " + paymentId);
		}
		return paymentItems.stream()
			.map(PaymentItemEntity::toDomain)
			.collect(Collectors.toList());
	}
}
