package com.example.insurancecompany.repository;

import com.example.insurancecompany.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

        Optional<Role> findByName(String name);

}
