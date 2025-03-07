package com.ilailson.crud_spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String youtubeUrl;

    //@ManyToOne... Muitas aulas para um curso
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "course_id", nullable = false)
    // dependencia circulare ou seja o curso depende da aula e a aula depende do curso
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // nós apenas vamos fazer o sett desse curso e não o gett
    private Course course;
}
