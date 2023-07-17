package com.HMRS.service;

import com.HMRS.model.Payroll;
import com.HMRS.model.Training;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PayrollService {
    List<Payroll> getAllPayrolls();
    void savePayroll(Payroll payroll);
    Payroll getPayrollByID(long jobId);
    void deletePayrollByID(long jobId);
    Page<Payroll> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
