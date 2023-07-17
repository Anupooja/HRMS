package com.HMRS.service;
import com.HMRS.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
    Employee getEmployeeByID(long sid);
    void deleteEmployeeByID(long sid);
    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
