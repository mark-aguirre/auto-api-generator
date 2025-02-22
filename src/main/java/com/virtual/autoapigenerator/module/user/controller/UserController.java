package com.virtual.autoapigenerator.module.user.controller;

import org.springframework.web.bind.annotation.*;
import com.virtual.autoapigenerator.module.user.service.UserService;
import com.virtual.autoapigenerator.module.user.model.request.UserRequest;
import com.virtual.autoapigenerator.module.user.model.response.UserResponse;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;


    @GetMapping
    public List<UserResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserResponse> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest user) {

//        user.setUuid("2454545");
//        user.setUsername("john");
//        user.setEmail("john@gmail.com");
//        user.setPassword("123456");
//        user.setIsActive(1);
//        user.setLogged(1);
//        user.setRole("admin");

        return service.save(user);
    }

    @PutMapping("/{id}")
    public UserResponse update(
        @PathVariable Long id,
        @RequestBody UserRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}