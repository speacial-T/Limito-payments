package com.limito.payment.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.limito.payment.infrastructure.persistence.jpa.PaymentJpaRepository;
import com.limito.payment.presentation.dto.request.ConfirmPaymentRequestV1;
import com.limito.payment.presentation.dto.request.OrderItem;
import com.limito.payment.presentation.dto.request.PortOneConfirmPaymentRequest;
import com.limito.payment.presentation.dto.response.ConfirmPaymentResponseV1;

import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceV1 {

	@Value("${portone.store-id}")
	private String storeId;
	private PaymentJpaRepository paymentJpaRepository;

	@Transactional
	public ConfirmPaymentRequestV1 getPayment(
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
		request.setTotalPrice(totalPrice);
		request.setItems(items);
		return request;
	}

	@Transactional
	public ConfirmPaymentResponseV1 confirmPayment(String paymentKey, ConfirmPaymentResponseV1 response) {

		response.setPaymentKey(paymentKey);
		log.info("Confirming payment for response: {}", response);

		return response;
	}
}
