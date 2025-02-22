package com.virtual.autoapigenerator.module.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtual.autoapigenerator.module.user.model.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}