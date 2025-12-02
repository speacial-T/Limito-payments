package com.limito.payment.presentation.dto.response;

import java.util.UUID;

import com.limito.payment.domain.model.PaymentSatusEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfirmPaymentResponseV1 {
	private UUID orderId;
	private UUID paymentId;
	private PaymentSatusEnum paymentStatus;
	private int amount;
	private String confirmedAt;
}
