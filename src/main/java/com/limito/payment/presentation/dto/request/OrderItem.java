package com.limito.payment.presentation.dto.request;

import java.util.UUID;

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
public class OrderItem {

	private UUID orderItemId;

	private String productName;

	private int productPrice;

	private int quantity;

	private Long sellerId;
}