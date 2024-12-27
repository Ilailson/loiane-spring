package com.ilailson.crud_spring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilailson.crud_spring.model.Course;
import com.ilailson.crud_spring.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;




    // public CourseController(CourseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // } mesma coisa @AllArgsConstructor

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }


}
