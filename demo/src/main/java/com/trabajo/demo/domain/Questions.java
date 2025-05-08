package com.trabajo.demo.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int score;

    @ManyToOne
    @JoinColumn(name = "typeoption_id", referencedColumnName = "id")
    private Type_options type_option;

    @NotNull
    @Size(max = 80)
    private String description;

    @OneToMany(mappedBy = "question")
    private List<Answers> answers;

    public Questions() {
    }

    public Questions(Long id, int score, Type_options type_option, String description) {
        this.id = id;
        this.score = score;
        this.type_option = type_option;
        this.description = description;
    }
}