package com.limito.payment.infrastructure.persistence.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limito.payment.domain.entity.PaymentEntity;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {

	Optional<PaymentEntity> findByOrderId(UUID orderId);
}
