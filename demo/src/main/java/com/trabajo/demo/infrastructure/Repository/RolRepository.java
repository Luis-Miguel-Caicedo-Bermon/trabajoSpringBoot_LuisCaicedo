package com.trabajo.demo.infrastructure.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajo.demo.domain.Role;

public interface RolRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Optional<Role> findById(Long id);
}
