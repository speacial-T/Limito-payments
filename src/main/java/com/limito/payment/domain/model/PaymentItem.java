package com.limito.payment.domain.model;

import java.util.UUID;

import com.limito.payment.infrastructure.persistence.entity.enums.PaymentSatusEnum;
import com.limito.payment.infrastructure.persistence.entity.PaymentEntity;

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

	private PaymentSatusEnum status;
}
