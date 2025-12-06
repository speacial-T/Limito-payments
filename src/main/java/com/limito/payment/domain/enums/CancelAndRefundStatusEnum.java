package com.limito.payment.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CancelAndRefundStatusEnum {
	REQUESTED("결제 취소/환불 요청"),
	APPROVED("결제 취소/환불 승인"),
	REJECTED("결제 취소/환불 거절"),
	FAILED("결제 취소/환불 실패");
	private final String description;
}