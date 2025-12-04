package com.limito.payment.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.limito.payment.domain.enums.CancelStatusEnum;
import com.limito.payment.domain.enums.PaymentMethodEnum;
import com.limito.payment.domain.enums.PaymentStatusEnum;
import com.limito.payment.infrastructure.persistence.entity.PaymentItemEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Payment {

	private UUID paymentId;

	private UUID orderId;

	private PaymentStatusEnum status;

	private String paymentKey;

	private Integer totalPrice;

	private String refundReason;

	private CancelStatusEnum cancelStatus;

	private LocalDateTime approvedAt;

	private LocalDateTime refundAt;

	private String failLog;

	private PaymentMethodEnum paymentMethod;

	private String cardLastNum;

	private String cardName;

	private String pgProvider;
	private List<PaymentItem> items = new ArrayList<>();
}
