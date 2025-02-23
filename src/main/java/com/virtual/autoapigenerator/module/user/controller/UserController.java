package com.virtual.autoapigenerator.module.user.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.virtual.autoapigenerator.module.user.service.UserService;
import com.virtual.autoapigenerator.module.user.model.request.UserRequest;
import com.virtual.autoapigenerator.module.user.model.response.UserResponse;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserResponse> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public UserResponse create(@Valid @RequestBody UserRequest user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public UserResponse update(
        @PathVariable Long id,
        @Valid @RequestBody UserRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}