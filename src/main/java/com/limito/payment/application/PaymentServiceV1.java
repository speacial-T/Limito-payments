package com.limito.payment.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.limito.payment.domain.repository.PaymentRepository;
import com.limito.payment.presentation.dto.request.CompletePaymentRequest;
import com.limito.payment.presentation.dto.request.ConfirmPaymentRequestV1;
import com.limito.payment.presentation.dto.request.OrderItem;
import com.limito.payment.presentation.dto.request.PortOneConfirmPaymentRequest;
import com.limito.payment.presentation.dto.response.ConfirmPaymentResponseV1;
import com.limito.payment.presentation.dto.response.PortOneConfirmPaymentResponse;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceV1 {
	private final PaymentRepository paymentRepository;

	@Value("${portone.store-id}")
	private String storeId;
	private final WebClient webClient;

	@Transactional
	public ConfirmPaymentRequestV1 preparePayment(
		UUID orderId
	) {
		log.info("Preparing payment for orderId: {}", orderId);
		ConfirmPaymentRequestV1 request = new ConfirmPaymentRequestV1();
		request.setOrderId(orderId);
		request.setItemSummary("샘플 상품 2개");
		// 더미 상품 데이터 (실제로는 payment.getItems()에서 가져옴)
		List<OrderItem> items = List.of(
			OrderItem.builder()
				.orderItemId(UUID.randomUUID())
				.productName("샘플 상품 1")
				.productPrice(5000)
				.quantity(1)
				.sellerId(1L)
				.build(),
			OrderItem.builder()
				.orderItemId(UUID.randomUUID())
				.productName("샘플 상품 2")
				.productPrice(3000)
				.quantity(2)
				.sellerId(2L)
				.build()
		);
		int totalPrice = 0;
		for (OrderItem item : items) {
			totalPrice += item.getProductPrice();
		}
		request.setTotalPrice(11000);
		request.setItems(items);
		return request;
	}

	@Transactional
	public PortOneConfirmPaymentRequest preparePayment(
		UUID orderId, ConfirmPaymentRequestV1 request
	) {
		log.info("Preparing payment for orderId: {}", orderId);

		PortOneConfirmPaymentRequest completeRequest = new PortOneConfirmPaymentRequest();
		completeRequest.setOrderId(orderId);
		// 더미 상품 데이터 (실제로는 payment.getItems()에서 가져옴)
		// TODO 여기서는 주문 서비스에서 받아온 정보를 적용하도록 수정 필요
		completeRequest.setItemSummary("샘플 상품 3개");
		completeRequest.setTotalPrice(11000);
		List<OrderItem> items = List.of(
			OrderItem.builder()
				.orderItemId(UUID.randomUUID())
				.productName("샘플 상품 1")
				.productPrice(5000)
				.quantity(1)
				.sellerId(1L)
				.build(),
			OrderItem.builder()
				.orderItemId(UUID.randomUUID())
				.productName("샘플 상품 2")
				.productPrice(3000)
				.quantity(2)
				.sellerId(2L)
				.build()
		);
		completeRequest.setItems(items);
		return completeRequest;
	}

	@Transactional
	public ConfirmPaymentResponseV1 confirmPayment(String paymentKey, ConfirmPaymentResponseV1 response) {

		log.info("Confirming payment for response: {}", response);
		System.out.println("Confirming payment for response: " + getRawPaymentJson(paymentKey, storeId));

		return response;
	}

	public Mono<String> getRawPaymentJson(String paymentKey, String storeId) {
		return webClient.get()
			.uri("/{paymentId}?storeId={storeId}", paymentKey, storeId)
			.retrieve()
			.bodyToMono(String.class); // JSON 문자열로 그대로 받음
	}
}
