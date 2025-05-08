package com.trabajo.demo.domain;

import java.sql.Timestamp;
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
@Table(name = "chapters")
@Getter
@Setter
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberchapter;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skills skill_id;

    private Timestamp created_at;
    private Timestamp updated_at;

    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    private String chapter_sumary;

    @OneToMany(mappedBy = "chapter_id")
    private List<Subchapters> subchapters;

    public Chapters() {
    }

    public Chapters(Long id, int numberchapter, Skills skill_id, Timestamp created_at, Timestamp updated_at,
            String description, String chapter_sumary) {
        this.id = id;
        this.numberchapter = numberchapter;
        this.skill_id = skill_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.chapter_sumary = chapter_sumary;
    }

    

}
