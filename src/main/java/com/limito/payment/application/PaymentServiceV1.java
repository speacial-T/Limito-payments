package com.limito.payment.application;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.limito.payment.presentation.dto.request.PaymentConfirmRequestV1;
import com.limito.payment.presentation.dto.response.PaymentConfirmResponseV1;

@Service
public class PaymentServiceV1 {

	public PaymentConfirmResponseV1 confirmPayment(UUID orderId, PaymentConfirmRequestV1 request) {
		// 결제 승인 로직 처리
		String confirmedAt = LocalDateTime.now().toString();

		return new PaymentConfirmResponseV1(
			orderId,
			UUID.randomUUID(),
			"CONFIRMED",
			request.getAmount(),
			confirmedAt
		);
	}

	public PaymentConfirmRequestV1 preparePayment(UUID orderId, PaymentConfirmRequestV1 request) {
		return PaymentConfirmRequestV1.builder().build();
	}
}
