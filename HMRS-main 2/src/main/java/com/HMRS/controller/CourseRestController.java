/*package com.HMRS.controller;

import com.HMRS.model.Training;
import com.HMRS.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/")
public class CourseRestController {

    @Autowired
    TrainingService trainingService;

    @RequestMapping(value = "/course/", method = RequestMethod.GET)
    public ResponseEntity<List<Training>> getAllCourses()
    {
        List<Training> course = trainingService.getAllClasses();
        if(course.isEmpty())
        {
            return new ResponseEntity<List<Training>>(HttpStatus.NO_CONTENT);
        }
        else
        {
            return new ResponseEntity<List<Training>>(course, HttpStatus.OK);
        }
    }
}*/