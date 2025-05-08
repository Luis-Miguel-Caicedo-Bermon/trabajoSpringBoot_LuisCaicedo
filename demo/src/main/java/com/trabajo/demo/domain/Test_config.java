package com.trabajo.demo.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test_config")
@Getter
@Setter
public class Test_config {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date end_date;
    private boolean is_active;
    private int score;
    private Date start_date;

    @NotNull
    @Size(max = 90)
    private String description;

    @NotNull
    private String test_summary;

    @OneToMany(mappedBy = "test_config")
    private List<Exams> exams;

    public Test_config() {
    }

    public Test_config(int id, Date end_date, boolean is_active, int score, Date start_date, String description, String test_summary) {
        this.id = id;
        this.end_date = end_date;
        this.is_active = is_active;
        this.score = score;
        this.start_date = start_date;
        this.description = description;
        this.test_summary = test_summary;
    }
}