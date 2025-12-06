package com.limito.payment.infrastructure.persistence.jpa;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.limito.payment.domain.dto.PaymentItemDto;
import com.limito.payment.domain.model.PaymentItemEntity;
import com.limito.payment.domain.model.PaymentItemMapper;
import com.limito.payment.domain.model.PaymentMapper;
import com.limito.payment.domain.repository.PaymentItemRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PaymentItemRepositoryImpl implements PaymentItemRepository {

	private final PaymentItemJpaRepository paymentItemJpaRepository;
	private final PaymentMapper mapper;
	private final PaymentItemMapper itemMapper;

	@Transactional
	@Override
	public List<PaymentItemDto> saveAll(List<PaymentItemDto> orderItems) {
		List<PaymentItemEntity> entities = orderItems.stream()
			.map(itemMapper::toEntity)
			.collect(Collectors.toList());

		paymentItemJpaRepository.saveAll(entities);
		return orderItems;
	}

	@Transactional(readOnly = true)
	@Override
	public List<PaymentItemDto> getPaymentItems(UUID paymentId) {
		List<PaymentItemEntity> paymentItems = paymentItemJpaRepository.findAllByPaymentPaymentId(paymentId);

		if (paymentItems.isEmpty()) {
			throw new IllegalArgumentException("No payment items found for paymentId: " + paymentId);
		}
		return paymentItems.stream()
			.map(itemMapper::toDomain)
			.collect(Collectors.toList());
	}

}
