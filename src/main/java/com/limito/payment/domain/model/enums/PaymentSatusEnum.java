package com.limito.payment.domain.model.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PaymentSatusEnum {
	IN_PROGRESS,
	SUCCESS,
	REFUND,
	FAILED;
}