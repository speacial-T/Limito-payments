package com.limito.payment.presentation.dto.request;

import java.util.List;
import java.util.UUID;

import org.antlr.v4.runtime.misc.NotNull;

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
public class ConfirmPaymentRequestV1 {

	private UUID orderId;

	private String itemSummary;

	private List<OrderItem> items;

	private UUID paymentId;

	private String status;

	private int amount;
}
