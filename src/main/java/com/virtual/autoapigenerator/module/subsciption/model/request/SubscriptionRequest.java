package com.virtual.autoapigenerator.module.subsciption.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
//    private Integer subscriptionId;
    private String userUuid;
    private Integer planId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private LocalDateTime renewalDate;
    private String paymentMethod;
    private Double amount;
    private String type;
//    private LocalDateTime updatedAt;
//    private LocalDateTime createdAt;


}