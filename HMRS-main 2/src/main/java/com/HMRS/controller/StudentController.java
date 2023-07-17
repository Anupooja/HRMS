package com.HMRS.controller;


import com.HMRS.model.Employee;
import com.HMRS.repository.EmployeeRepository;
import com.HMRS.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller

public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/studentList")
    public String viewStudentPage(Model model)
    {
        model.addAttribute("listStudents", employeeService.getAllEmployees());
        return "student_list";
    }

    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model)
    {
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("student", employee);
        return "new_student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Employee employee)
    {
        //save student to database
        employeeService.saveEmployee(employee);
        System.out.println("saving student and going back to student list");
        return "redirect:/studentList";//studentList


    }

    @RequestMapping(value = "/get/{sid}")
    public String getStudentId(@PathVariable("sid") long sid, Model model)
    {

        Optional<Employee> findStudentId = employeeRepository.findById(sid);

        //model.addAttribute("name", "name");
        //model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("student", findStudentId);

        log.info("getStudentId() : " + sid);
        return "redirect:/studentList";

    }

    @GetMapping("/showStudFormForUpdate/{sid}")
    public String showStudFormForUpdate(@PathVariable(value = "sid") Long sid, Model model)
    {
        //get student from the service
        Employee employee = employeeService.getEmployeeByID(sid);

        model.addAttribute("student", employee);
        System.out.print("going to update student html");
        return "update_student";
    }

    @GetMapping("/deleteStudent/{sid}")
    public String deleteStudent(@PathVariable(value = "sid") long sid)
    {
        //call delete student method
        this.employeeService.deleteEmployeeByID(sid);
        return "redirect:/studentList";
    }

}
