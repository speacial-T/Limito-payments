package com.limito.payment.domain.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.limito.common.audit.BaseEntity;
import com.limito.payment.domain.enums.CancelAndRefundStatusEnum;
import com.limito.payment.domain.enums.PaymentMethodEnum;
import com.limito.payment.domain.enums.PaymentStatusEnum;
import com.limito.payment.domain.model.Payment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "p_payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class PaymentEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "payment_id", columnDefinition = "UUID")
	private UUID paymentId;

	@Column(name = "order_id", nullable = false, columnDefinition = "UUID")
	private UUID orderId;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentStatusEnum paymentStatus;

	@Column(name = "payment_key", length = 50)
	private String paymentKey;

	@Column(name = "item_summary", nullable = false, length = 50)
	private String itemSummary;

	@Column(name = "total_price", nullable = false)
	private Integer totalPrice;

	@Column(name = "refund_reason", length = 100)
	private String refundReason;

	@Enumerated(EnumType.STRING)
	@Column(name = "cancel_status")
	private CancelAndRefundStatusEnum cancelAndRefundStatus;

	@Column(name = "approved_at")
	private LocalDateTime approvedAt;

	@Column(name = "refund_at")
	private LocalDateTime refundAt;

	@Column(name = "fail_log", length = 100)
	private String failLog;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethodEnum paymentMethod;

	@Column(name = "card_num", length = 50)
	private String cardNum;

	@Column(name = "card_name", length = 50)
	private String cardName;

	@Column(name = "pg_provider", length = 50)
	private String pgProvider;

	@OneToMany(mappedBy = "payment", orphanRemoval = true)
	private List<PaymentItemEntity> items = new ArrayList<>();

	public static Payment toDomain(PaymentEntity p) {
		return Payment.builder()
			.paymentId(p.paymentId)
			.orderId(p.orderId)
			.status(p.status)
			.paymentKey(p.paymentKey)
			.totalPrice(p.totalPrice)
			.refundReason(p.refundReason)
			.cancelStatus(p.cancelStatus)
			.approvedAt(p.approvedAt)
			.refundAt(p.refundAt)
			.failLog(p.failLog)
			.paymentMethod(p.paymentMethod)
			.cardNum(p.cardNum)
			.cardName(p.cardName)
			.pgProvider(p.pgProvider)
			.items(p.items.stream()
				.map(item -> PaymentItemEntity.toDomain(item))
				.collect(Collectors.toList()))
			.build();

	}
}
