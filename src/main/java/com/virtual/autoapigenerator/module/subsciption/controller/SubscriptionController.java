package com.virtual.autoapigenerator.module.subsciption.controller;

import org.springframework.web.bind.annotation.*;
import com.virtual.autoapigenerator.module.subsciption.service.SubscriptionService;
import com.virtual.autoapigenerator.module.subsciption.model.request.SubscriptionRequest;
import com.virtual.autoapigenerator.module.subsciption.model.response.SubscriptionResponse;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/subscription")
public class SubscriptionController {

    private final SubscriptionService service;

    

    @GetMapping
    public List<SubscriptionResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SubscriptionResponse> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public SubscriptionResponse create(@RequestBody SubscriptionRequest request) {

        return service.save(request);
    }

    @PutMapping("/{id}")
    public SubscriptionResponse update(
        @PathVariable Long id,
        @RequestBody SubscriptionRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}