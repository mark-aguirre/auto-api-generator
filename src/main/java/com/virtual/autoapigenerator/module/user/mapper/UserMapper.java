package com.virtual.autoapigenerator.module.user.mapper;

import com.virtual.autoapigenerator.module.user.model.request.UserRequest;
import com.virtual.autoapigenerator.module.user.model.response.UserResponse;
import com.virtual.autoapigenerator.module.user.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget; // Import for @MappingTarget

@Mapper
public interface UserMapper {

    UserResponse toResponse(User entity);
    User toEntity(UserRequest dto);

    // Add the missing method:
    void updateFromDto(UserRequest request, @MappingTarget User entity); // Important!
}