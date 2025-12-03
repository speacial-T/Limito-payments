package com.limito.payment.infrastructure.persistence.entity;

import java.util.UUID;

import com.limito.common.entity.BaseEntity;
import com.limito.payment.infrastructure.persistence.entity.enums.PaymentSatusEnum;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_payment_items")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class PaymentItemEntity extends BaseEntity {

	@Id
	@Column(name = "payment_item_id", columnDefinition = "UUID")
	private UUID paymentItemId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id", nullable = false)
	private PaymentEntity payment;

	@Column(name = "order_id", nullable = false, columnDefinition = "UUID")
	private UUID orderId;

	@Column(name = "seller_id")
	private Long sellerId;

	@Column(name = "order_item_id", nullable = false, columnDefinition = "UUID")
	private UUID orderItemId;

	@Column(name = "product_name", length = 100, nullable = false)
	private String productName;

	@Column(name = "product_price", nullable = false)
	private Integer productPrice;

	@Column(name = "product_amount", nullable = false)
	private Integer productAmount;

	@Column(name = "refund_price")
	private Long refundPrice;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PaymentSatusEnum status;
}
