package com.trabajo.demo.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "media_types")
@Getter
@Setter
public class Media_types {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "media_type_id")
    private List<Media_sub_Chapters> media_sub_Chapters; 

    public Media_types() {
    }
    public Media_types(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    
}
