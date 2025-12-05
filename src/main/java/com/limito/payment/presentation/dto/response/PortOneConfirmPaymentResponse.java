package com.limito.payment.presentation.dto.response;

import java.util.UUID;

import com.limito.payment.domain.enums.PaymentStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PortOneConfirmPaymentResponse {
	private UUID orderId;
	private String paymentKey;
	private PaymentStatusEnum paymentStatus;
	private int amount;
	private String confirmedAt;
}
