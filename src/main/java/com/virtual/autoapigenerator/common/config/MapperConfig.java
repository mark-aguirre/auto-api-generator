package com.virtual.autoapigenerator.common.config;

import com.virtual.autoapigenerator.module.subsciption.mapper.SubscriptionMapper;
import com.virtual.autoapigenerator.module.user.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
   public SubscriptionMapper subscriptionMapper() {
       return Mappers.getMapper(SubscriptionMapper.class);
   }

    @Bean
    public UserMapper userMapper() {

        return Mappers.getMapper(UserMapper.class);
    }
}