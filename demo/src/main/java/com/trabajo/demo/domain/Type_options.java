package com.trabajo.demo.domain;

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
@Table(name = "type_options")
@Getter
@Setter
public class Type_options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    private String description;

    @NotNull
    @Size(max = 80)
    private String tag_option;

    @OneToMany(mappedBy = "type_option")
    private List<Questions> questions;

    public Type_options(){

    }

    public Type_options(Long id, String description, String tag_option) {
        this.id = id;
        this.description = description;
        this.tag_option = tag_option;
    }

    
}
