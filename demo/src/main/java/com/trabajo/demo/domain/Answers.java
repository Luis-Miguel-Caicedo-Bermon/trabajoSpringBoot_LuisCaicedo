package com.trabajo.demo.domain;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean is_correct;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    private Questions question;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @NotNull
    @Size(max = 80)
    private String description;

    public Answers() {
    }

    public Answers(Long id, boolean is_correct, Questions question, Timestamp createdAt, Timestamp updatedAt, String description) {
        this.id = id;
        this.is_correct = is_correct;
        this.question = question;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
    }
}