package com.trabajo.demo.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exams")
@Getter
@Setter
public class Exams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date_presentation;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "test_config_id",referencedColumnName = "id")
    private Test_config test_config;

    public Exams(){

    }

    public Exams(Long id, Date date_presentation, Students student, Test_config test_config) {
        this.id = id;
        this.date_presentation = date_presentation;
        this.student = student;
        this.test_config = test_config;
    }

}
