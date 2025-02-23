package com.virtual.autoapigenerator.module.user.service;

import org.springframework.stereotype.Service;
import com.virtual.autoapigenerator.module.user.repository.UserRepository;
import com.virtual.autoapigenerator.module.user.mapper.UserMapper;
import com.virtual.autoapigenerator.module.user.model.entities.User;
import com.virtual.autoapigenerator.module.user.model.request.UserRequest;
import com.virtual.autoapigenerator.module.user.model.response.UserResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<UserResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<UserResponse> findById(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public UserResponse save(UserRequest request) {
        User entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    public UserResponse update(Long id, UserRequest request) {
        User existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));

        mapper.updateFromDto(request, existingEntity);

        User savedEntity = repository.save(existingEntity);
        return mapper.toResponse(savedEntity);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}