package com.HMRS.service;
import com.HMRS.model.Employee;
import com.HMRS.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServiceImplTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void getAllStudents(){
        List<Employee> items = employeeRepository.findAll();
        assertEquals(7, items.size());
    }

    @Test
    public void testFindOne(){
        Employee employee = employeeRepository.getReferenceById(1425L);
        assertEquals("melind", employee.getStudName());
    }


}
