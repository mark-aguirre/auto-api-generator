package com.virtual.autoapigenerator.module.user.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private Integer isActive = 1;

    @Column(name = "logged")
    private Integer logged = 0;

    @Column(name = "role")
    private String role;

    @Column(name = "date_last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastModified;

    @Column(name = "date_created", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();


}
