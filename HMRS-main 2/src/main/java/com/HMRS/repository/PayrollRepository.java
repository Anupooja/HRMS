package com.HMRS.repository;

import com.HMRS.model.Employee;
import com.HMRS.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
}
