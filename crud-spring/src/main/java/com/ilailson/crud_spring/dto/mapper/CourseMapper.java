package com.ilailson.crud_spring.dto.mapper;

import org.springframework.stereotype.Component;

import com.ilailson.crud_spring.dto.CourseDTO;
import com.ilailson.crud_spring.model.Course;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null; //evitar nullpointer
        }

        return new CourseDTO(course.getId(), course.getName(), course.getCategory());
    }

    public Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();

        if (courseDTO == null) {
            return null; //evitar nullpointer

        }
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());
        return  course;

        //lê Builder pattern. Para vários campos
    }
}
