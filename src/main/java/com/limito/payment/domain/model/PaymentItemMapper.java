package com.limito.payment.domain.model;

import org.springframework.stereotype.Component;

import com.limito.payment.domain.dto.PaymentItemDto;

@Component
public class PaymentItemMapper {

	public PaymentItemDto toDomain(PaymentItemEntity entity) {
		return PaymentItemDto.builder()
			.paymentItemId(entity.paymentItemId)
			.sellerId(entity.sellerId)
			.orderItemId(entity.orderItemId)
			.productName(entity.productName)
			.productPrice(entity.productPrice)
			.productType(entity.productType)
			.productAmount(entity.productAmount)
			.refundPrice(entity.refundPrice)
			.status(entity.status)
			// payment는 순환 참조 방지를 위해 제외
			.build();
	}

	public PaymentItemEntity toEntity(PaymentItemDto dto) {
		return new PaymentItemEntity(
			dto.getPaymentItemId(),
			null,  // Payment는 별도로 설정 (순환 참조 방지)
			dto.getSellerId(),
			dto.getOrderItemId(),
			dto.getProductName(),
			dto.getProductPrice(),
			dto.getProductType(),
			dto.getProductAmount(),
			dto.getRefundPrice(),
			dto.getStatus()
		);
	}
}
