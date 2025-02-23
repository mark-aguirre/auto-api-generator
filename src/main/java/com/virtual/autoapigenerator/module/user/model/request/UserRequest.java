package com.virtual.autoapigenerator.module.user.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

//    @NotBlank(message = "UUID cannot be blank")
    private String uuid;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters") // Example: enforce minimum length
    private String password;

    @NotNull(message = "isActive cannot be null")
    @Min(value = 0, message = "isActive must be 0 or 1")
    @Max(value = 1, message = "isActive must be 0 or 1")
    private Integer isActive;

    @NotNull(message = "logged cannot be null")
    @Min(value = 0, message = "logged must be 0 or 1")
    @Max(value = 1, message = "logged must be 0 or 1")
    private Integer logged;


    @NotBlank(message = "Role cannot be blank")
    private String role; // You might want to restrict this to specific roles (e.g., using an enum)

}