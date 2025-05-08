package com.trabajo.demo.domain;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private Timestamp created_at;
    private Timestamp updated_at;

    @NotNull
    @Size(max = 80)
    private String iconurl;
    
    @NotNull
    @Size(max = 80)
    private String skill_name;

    @NotNull
    private String skill_description;

    @OneToMany(mappedBy = "skill")
    private List<Skill_route_path> skill_route_paths;

    @OneToMany(mappedBy = "skill_id")
    private List<Chapters> chapters;

    public Skills(Long id, Timestamp created_at, Timestamp updated_at, String iconurl, String skill_name,String skill_description) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.iconurl = iconurl;
        this.skill_name = skill_name;
        this.skill_description = skill_description;
    }

}
