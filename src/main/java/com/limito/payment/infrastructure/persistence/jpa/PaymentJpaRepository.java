package com.limito.payment.infrastructure.persistence.jpa;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.limito.payment.infrastructure.persistence.entity.PaymentEntity;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {
}
