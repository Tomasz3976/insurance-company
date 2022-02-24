package com.example1.insurancecompany.repository;

import com.example1.insurancecompany.domain.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
