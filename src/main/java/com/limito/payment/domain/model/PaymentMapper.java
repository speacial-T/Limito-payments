package com.limito.payment.domain.model;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.limito.payment.domain.dto.PaymentDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentMapper {

	private final PaymentItemMapper itemMapper;

	public PaymentEntity toEntity(PaymentDto dto) {
		return new PaymentDto(
			dto.getPaymentId(),
			dto.getOrderId(),
			dto.getPaymentStatus(),
			dto.getPaymentKey(),
			dto.getItemSummary(),
			dto.getTotalPrice(),
			dto.getRefundReason(),
			dto.getCancelAndRefundStatus(),
			dto.getApprovedAt(),
			dto.getRefundAt(),
			dto.getFailLog(),
			dto.getPaymentMethod(),
			dto.getCardNum(),
			dto.getCardName(),
			dto.getPgProvider(),
			dto.getItems() != null
				? dto.getItems().stream()
				.map(itemMapper::toEntity)
				.collect(Collectors.toList())
				: null
		);
	}

	public PaymentDto toDomain(PaymentEntity entity) {
		return PaymentDto.builder()
			.paymentId(entity.paymentId)           // 필드 직접 접근
			.orderId(entity.orderId)
			.paymentStatus(entity.paymentStatus)
			.paymentKey(entity.paymentKey)
			.itemSummary(entity.itemSummary)
			.totalPrice(entity.totalPrice)
			.refundReason(entity.refundReason)
			.cancelAndRefundStatus(entity.cancelAndRefundStatus)
			.approvedAt(entity.approvedAt)
			.refundAt(entity.refundAt)
			.failLog(entity.failLog)
			.paymentMethod(entity.paymentMethod)
			.cardNum(entity.cardNum)
			.cardName(entity.cardName)
			.pgProvider(entity.pgProvider)
			.items(entity.items != null
				? entity.items.stream()
				.map(itemMapper::toDto)
				.collect(Collectors.toList())
				: null)
			.build();
	}
}