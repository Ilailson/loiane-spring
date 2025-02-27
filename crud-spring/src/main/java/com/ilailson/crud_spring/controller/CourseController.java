package com.ilailson.crud_spring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ilailson.crud_spring.model.Course;
import com.ilailson.crud_spring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseRepository courseRepository;



    @GetMapping("/{id}")// utilizado para visualizar só os ativos da deleção lógica com hibernate 
    public ResponseEntity<Course> findById(@PathVariable @NotNull @Positive Long id) {
        return courseRepository
                .findById(id)
                .map(record -> ResponseEntity.ok(record))
                .orElse(ResponseEntity.notFound().build());
      }

    // public CourseController(CourseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // } mesma coisa @AllArgsConstructor

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping // utilizado para visualizar só os ativos da deleção lógica com hibernate 
    public List<Course> list(){
        return courseRepository.findAll();
    }

    // @RequestMapping(method =  RequestMethod.POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course) {
        return courseRepository.save(course);
        // System.out.println(course.getName());
        // return ResponseEntity
        //         .status(HttpStatus.CREATED)
        //         .body(courseRepository.save(course));

        // @Valid. Garantir envio de dados corretos de acordo com a validação do modelo
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Course course) {
        return courseRepository
                .findById(id) // Usando a instância correta
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    Course updated = courseRepository.save(recordFound);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") // utilizado na deleção lógica com hibernate 
    public ResponseEntity<Void>  delete(@PathVariable @NotNull @Positive Long id){
        return courseRepository
                .findById(id) // Usando a instância correta
                .map(recordFound -> {
                    courseRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());

    }

}
