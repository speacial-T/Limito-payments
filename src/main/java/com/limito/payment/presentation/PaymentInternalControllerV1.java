package com.limito.payment.presentation;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limito.payment.application.PaymentServiceV1;
import com.limito.payment.presentation.dto.request.ConfirmPaymentRequestV1;
import com.limito.payment.presentation.dto.response.ConfirmPaymentResponseV1;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/internal/v1/payments")
@RequiredArgsConstructor
public class PaymentInternalControllerV1 {

	private final PaymentServiceV1 paymentService;

	@PostMapping("/{orderId}/confirm")
	public ResponseEntity<ConfirmPaymentResponseV1> confirmPayment(
		@PathVariable String orderId,
		@RequestBody ConfirmPaymentRequestV1 request) {

		ConfirmPaymentRequestV1 response = paymentService.preparePayment(UUID.fromString(orderId), request);
		// return ResponseEntity.ok(response);
		return new ResponseEntity<ConfirmPaymentResponseV1>(
			new ConfirmPaymentResponseV1(), HttpStatus.OK);
	}
}
