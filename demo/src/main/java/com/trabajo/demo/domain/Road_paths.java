package com.trabajo.demo.domain;

import java.sql.Timestamp;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "road_paths")
@Getter
@Setter
public class Road_paths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isactive;
    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(length = 80)
    private String image_path;

    @NotNull
    @Column(nullable = false,length = 80)
    private String path_name;

    @NotNull
    private String description;

    @OneToMany(mappedBy = "road_path")
    private List<Skill_route_path> skill_route_paths;

    public Road_paths() {
    }

    public Road_paths(Long id, boolean isactive, Timestamp created_at, Timestamp updated_at, String image_path,
            String path_name,String description) {
        this.id = id;
        this.isactive = isactive;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.image_path = image_path;
        this.path_name = path_name;
        this.description = description;
    }

    
}
