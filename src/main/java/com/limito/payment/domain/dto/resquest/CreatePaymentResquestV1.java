package com.limito.payment.domain.dto.resquest;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import com.limito.payment.presentation.dto.request.OrderItem;

@Getter
@Setter
@NotBlank
public class CreatePaymentResquestV1 {
	@NotNull(message = "주문자 아이디는 필수입니다.")
	private Long orderId;
	@NotBlank(message = "상품 요약은 필수입니다.")
	private String itemSummary;
	@NotNull(message = "총 결제 금액은 필수입니다.")
	private int totalPrice;
	@Size(min = 1, message = "결제 상품은 최소 1개 이상이어야 합니다.")
	private List<OrderItem> items;
}
