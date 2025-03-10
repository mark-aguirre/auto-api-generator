package com.virtual.autoapigenerator.module.user.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
//    private Integer userId;
//    private String uuid;
    private String username;
    private String email;
    private String password;
    private Integer isActive;
    private Integer logged;
    private String role;
//    private Date dateLastModified;
//    private Date dateCreated;


}