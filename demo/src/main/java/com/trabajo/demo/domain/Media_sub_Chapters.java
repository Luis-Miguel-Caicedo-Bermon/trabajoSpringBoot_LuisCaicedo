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
@Table(name = "media_sub_chapters")
@Getter
@Setter
public class Media_sub_Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Media_types media_type_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Subchapters subchapter_id;

    private Timestamp created_at;
    private Timestamp updated_at;

    
    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    private String summary;

    public Media_sub_Chapters() {
    }   

    public Media_sub_Chapters(Long id, Media_types media_type_id, Subchapters subchapter_id, Timestamp created_at,
            Timestamp updated_at, String description, String summary) {
        this.id = id;
        this.media_type_id = media_type_id;
        this.subchapter_id = subchapter_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.summary = summary;
    }
}
