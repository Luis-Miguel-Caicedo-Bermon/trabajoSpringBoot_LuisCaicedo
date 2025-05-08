package com.trabajo.demo.domain;

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
@Table(name = "test_questions")
@Getter
@Setter
public class Test_questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id",referencedColumnName = "id")
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "test_config_id",referencedColumnName = "id")
    private Test_config test_config;

    public Test_questions() {
    }

    public Test_questions(Long id, Questions question, Test_config test_config) {
        this.id = id;
        this.question = question;
        this.test_config = test_config;
    }

    
}
