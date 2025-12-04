package com.limito.payment.application.dto.resquest;

import java.util.List;
import java.util.UUID;

import com.limito.payment.domain.enums.PaymentStatusEnum;
import com.limito.payment.presentation.dto.request.OrderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NotBlank
public class CreatePaymentItemResquestV1 {
	@NotNull(message = "주문자 아이디는 필수입니다.")
	private UUID orderId;
	@NotBlank(message = "상품 요약은 필수입니다.")
	private String itemSummary;
	@NotNull(message = "총 결제 금액은 필수입니다.")
	private int totalPrice;
	@Size(min = 1, message = "결제 상품은 최소 1개 이상이어야 합니다.")
	private List<OrderItem> items;

}
