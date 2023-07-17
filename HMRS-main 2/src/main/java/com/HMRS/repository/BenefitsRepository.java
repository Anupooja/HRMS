package com.HMRS.repository;

import com.HMRS.model.Benefits;
import com.HMRS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitsRepository extends JpaRepository<Benefits, Integer> {
}
