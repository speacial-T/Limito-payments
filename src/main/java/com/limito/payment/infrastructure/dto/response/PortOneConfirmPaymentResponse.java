package com.limito.payment.infrastructure.dto.response;

import java.util.UUID;

import com.limito.payment.infrastructure.persistence.entity.enums.PaymentSatusEnum;

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
	private PaymentSatusEnum paymentStatus;
	private int amount;
	private String confirmedAt;
}
