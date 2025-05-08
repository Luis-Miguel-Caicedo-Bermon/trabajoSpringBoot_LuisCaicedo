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
@Table(name = "subchapters")
@Getter
@Setter
public class Subchapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", referencedColumnName = "id")
    private Chapters chapter_id;

    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    private String summary;

    @OneToMany(mappedBy = "subchapter_id")
    private List<Media_sub_Chapters> media_sub_Chapters;

    public Subchapters() {
    }

    public Subchapters(Long id, Chapters chapter_id, String description, String summary) {
        this.id = id;
        this.chapter_id = chapter_id;
        this.description = description;
        this.summary = summary;
    }
}
