package com.HMRS.service;

import com.HMRS.model.Employee;
import com.HMRS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee)
    {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByID(long sID)
    {
        Optional<Employee> optional = employeeRepository.findById(sID);
        Employee employee = null;
        if(optional.isPresent())
        {
            employee = optional.get();
        }
        else
        {
            throw new RuntimeException("Employee not found for ID: " + sID);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeByID(long sID)
    {
        this.employeeRepository.deleteById(sID);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection)
    {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1 , pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }
}
