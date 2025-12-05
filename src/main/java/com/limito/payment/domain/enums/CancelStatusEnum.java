package com.limito.payment.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CancelStatusEnum {
	REQUESTED("환불 요청"),
	APPROVED("환불 승인"),
	REJECTED("환불 거절"),
	FAILED("환불 실패");
	private final String description;
}
