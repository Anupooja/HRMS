package com.HMRS.controller;

import java.util.List;

import com.HMRS.model.Training;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.HMRS.service.TrainingService;

/**
 * Controller class for managing courses.
 */
@Controller
public class CourseController {

    @Autowired
    private TrainingService trainingService;

    /**
     * Displays the home page with a list of courses.
     *
     * @param model the model object for the view
     * @return the name of the view template
     */
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listCourses", trainingService.getAllClasses());
        return "index";
    }

    /**
     * Displays the form for creating a new course.
     *
     * @param model the model object for the view
     * @return the name of the view template
     */
    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model) {
        Training training = new Training();
        model.addAttribute("course", training);
        return "new_course";
    }

    /**
     * Saves a new course to the database.
     *
     * @param training the course to be saved
     * @return a redirect URL to the home page
     */
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") Training training) {
        trainingService.saveClass(training);
        return "redirect:/";
    }

    /**
     * Displays the form for updating an existing course.
     *
     * @param id    the ID of the course to be updated
     * @param model the model object for the view
     * @return the name of the view template
     */
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Training training = trainingService.getClassByID(id);
        model.addAttribute("course", training);
        return "update_course";
    }

    /**
     * Deletes a course from the database.
     *
     * @param id the ID of the course to be deleted
     * @return a redirect URL to the home page
     */
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable(value = "id") long id) {
        trainingService.deleteClassByID(id);
        return "redirect:/";
    }

    /**
     * Displays a paginated list of courses.
     *
     * @param pageNo   the current page number
     * @param sortField the field to sort the results by
     * @param sortDir   the sort direction (asc or desc)
     * @param model     the model object for the view
     * @return the name of the view template
     */
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Training> page = trainingService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Training> listCours = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listCourses", listCours);

        return "index";
    }
}
