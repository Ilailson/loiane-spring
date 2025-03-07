package com.ilailson.crud_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ilailson.crud_spring.enums.Category;
import com.ilailson.crud_spring.model.Course;
import com.ilailson.crud_spring.model.Lesson;
import com.ilailson.crud_spring.repository.CourseRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory(Category.FRONT_END);

			Lesson l = new Lesson();
			l.setName("Introdução ao Angular");
			l.setYoutubeUrl("outubcom");
			l.setCourse(c);
			c.getLessons().add(l);

			Lesson l1 = new Lesson();
			l1.setName("Angular");
			l1.setYoutubeUrl("outubcom2");
			l1.setCourse(c);
			c.getLessons().add(l1);

			courseRepository.save(c);

		};
	}

}
