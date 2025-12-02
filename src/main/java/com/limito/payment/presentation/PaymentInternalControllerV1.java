package com.limito.payment.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limito.payment.application.PaymentService;
import com.limito.payment.presentation.dto.request.PaymentConfirmRequestV1;
import com.limito.payment.presentation.dto.response.PaymentConfirmResponseV1;

@RestController
@RequestMapping("/internal/v1/payments")
public class PaymentInternalControllerV1 {

	private final PaymentService paymentService;

	public PaymentInternalController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/{orderId}/confirm")
	public ResponseEntity<PaymentConfirmResponseV1> confirmPayment(
		@PathVariable String orderId,
		@RequestBody PaymentConfirmRequestV1 request) {

		PaymentConfirmResponseV1 response = paymentService.confirmPayment(orderId, request);
		return ResponseEntity.ok(response);
	}
}
