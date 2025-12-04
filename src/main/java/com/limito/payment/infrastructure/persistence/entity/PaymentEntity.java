package com.limito.payment.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.limito.common.entity.BaseEntity;
import com.limito.payment.domain.enums.CancelStatusEnum;
import com.limito.payment.domain.enums.PaymentMethodEnum;
import com.limito.payment.domain.enums.PaymentStatusEnum;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PaymentEntity extends BaseEntity {

	@Id
	@Column(name = "payment_id", columnDefinition = "UUID")
	private UUID paymentId;

	@Column(name = "order_id", nullable = false, columnDefinition = "UUID")
	private UUID orderId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatusEnum status;

	@Column(name = "payment_key", nullable = false, length = 50)
	private String paymentKey;

	@Column(name = "total_price", nullable = false)
	private Integer totalPrice;

	@Column(name = "refund_reason", length = 100)
	private String refundReason;

	@Enumerated(EnumType.STRING)
	@Column(name = "cancel_status")
	private CancelStatusEnum cancelStatus;

	@Column(name = "approved_at")
	private LocalDateTime approvedAt;

	@Column(name = "refund_at")
	private LocalDateTime refundAt;

	@Column(name = "fail_log", length = 100)
	private String failLog;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethodEnum paymentMethod;

	@Column(name = "card_last_num", length = 50)
	private String cardLastNum;

	@Column(name = "card_name", length = 50)
	private String cardName;

	@Column(name = "pg_provider", length = 50)
	private String pgProvider;

	@OneToMany(mappedBy = "payment", orphanRemoval = true)
	private List<PaymentItemEntity> items = new ArrayList<>();
}
