package com.limito.payment.infrastructure.persistence.entity.enums;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum PaymentSatusEnum {
	IN_PROGRESS,
	SUCCESS,
	REFUND,
	FAILED;
}