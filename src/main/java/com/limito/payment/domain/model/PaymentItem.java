package com.limito.payment.domain.model;

import java.util.UUID;

import com.limito.payment.domain.enums.PaymentStatusEnum;
import com.limito.payment.infrastructure.persistence.entity.PaymentEntity;
import com.limito.payment.infrastructure.persistence.entity.PaymentItemEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PaymentItem {

	private UUID paymentItemId;

	private PaymentEntity payment;

	private UUID orderId;

	private Long sellerId;

	private UUID orderItemId;

	private String productName;

	private Integer productPrice;

	private Integer productAmount;

	private Long refundPrice;

	private PaymentStatusEnum status;

	public static PaymentItemEntity toEntity(PaymentItem pi) {
		return PaymentItemEntity.builder()
			.paymentItemId(pi.paymentItemId)
			.payment(pi.payment)
			.orderId(pi.orderId)
			.sellerId(pi.sellerId)
			.orderItemId(pi.orderItemId)
			.productName(pi.productName)
			.productPrice(pi.productPrice)
			.productAmount(pi.productAmount)
			.refundPrice(pi.refundPrice)
			.status(pi.status)
			.build();
	}

}
