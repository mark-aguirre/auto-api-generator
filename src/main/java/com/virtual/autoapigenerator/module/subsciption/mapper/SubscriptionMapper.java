package com.virtual.autoapigenerator.module.subsciption.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.virtual.autoapigenerator.module.subsciption.model.request.SubscriptionRequest;
import com.virtual.autoapigenerator.module.subsciption.model.response.SubscriptionResponse;
import com.virtual.autoapigenerator.module.subsciption.model.entity.Subscription;

@Mapper
public interface SubscriptionMapper {
    SubscriptionResponse toResponse(Subscription entity);
    Subscription toEntity(SubscriptionRequest dto);
    void updateFromDto(SubscriptionRequest dto, @MappingTarget Subscription entity);
}