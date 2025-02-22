package com.virtual.autoapigenerator.module.subsciption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtual.autoapigenerator.module.subsciption.model.entity.Subscription;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}