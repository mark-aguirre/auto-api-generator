package com.virtual.autoapigenerator.module.subsciption.service;

import org.springframework.stereotype.Service;
import com.virtual.autoapigenerator.module.subsciption.repository.SubscriptionRepository;
import com.virtual.autoapigenerator.module.subsciption.mapper.SubscriptionMapper;
import com.virtual.autoapigenerator.module.subsciption.model.entity.Subscription;
import com.virtual.autoapigenerator.module.subsciption.model.request.SubscriptionRequest;
import com.virtual.autoapigenerator.module.subsciption.model.response.SubscriptionResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;


@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;
    private final SubscriptionMapper mapper;

    public SubscriptionService(SubscriptionRepository repository, SubscriptionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<SubscriptionResponse> findAll() {
        return repository.findAll()
                         .stream()
                         .map(mapper::toResponse)
                         .collect(Collectors.toList());
    }

    public Optional<SubscriptionResponse> findById(Long id) {
        return repository.findById(id).map(mapper::toResponse);
    }

    public SubscriptionResponse save(SubscriptionRequest request) {
        Subscription entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    public SubscriptionResponse update(Long id, SubscriptionRequest request) {
        Subscription existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id " + id));
        
        mapper.updateFromDto(request, existingEntity);
        
        Subscription savedEntity = repository.save(existingEntity);
        return mapper.toResponse(savedEntity);
    }



    public void delete(Long id) {
        repository.deleteById(id);
    }
}