package com.limito.payment.presentation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.limito.payment.application.PaymentServiceV1;
import com.limito.payment.presentation.dto.request.ConfirmPaymentRequestV1;
import com.limito.payment.presentation.dto.response.ConfirmPaymentResponseV1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1/payments")
public class PaymentControllerV1 {

	@Value("${portone.store-id}")
	private String storeId;

	@Value("${portone.channel-key}")
	private String channelKey;

	private final PaymentServiceV1 paymentService;

	@GetMapping("/{orderId}/page")
	public String showPaymentPage(
		@PathVariable("orderId") UUID orderId,
		Model model
	) {

		ConfirmPaymentRequestV1 paymentData = paymentService.preparePayment(orderId);
		model.addAttribute("orderId", orderId.toString());
		model.addAttribute("itemSummary", paymentData.getItemSummary());
		model.addAttribute("items", paymentData.getItems());
		model.addAttribute("totalPrice", paymentData.getTotalPrice());
		model.addAttribute("storeId", storeId);
		model.addAttribute("channelKey", channelKey);

		return "payment/portOne"; // templates/payment/portOne.html
	}

	@PostMapping("/{paymentId}/confirm")
	public ResponseEntity<ConfirmPaymentResponseV1> confirmPayment(
		@PathVariable("paymentId") String paymentKey
	) {
		log.info("paymentKey={}", paymentKey);
		ConfirmPaymentResponseV1 response = new ConfirmPaymentResponseV1();
		response.setPaymentKey(paymentKey);

		response = paymentService.confirmPayment(paymentKey, null);
		return ResponseEntity.ok(response);
	}
}