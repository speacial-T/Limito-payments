package com.limito.payment.domain.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PaymentStatusEnum {
	IN_PROGRESS,
	SUCCESS,
	REFUND,
	FAILED;
}