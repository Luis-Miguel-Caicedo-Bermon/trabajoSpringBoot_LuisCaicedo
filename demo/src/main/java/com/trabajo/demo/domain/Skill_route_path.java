package com.trabajo.demo.domain;

import java.sql.Timestamp;

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
@Table(name = "Skill_route_path")
@Getter
@Setter
public class Skill_route_path {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "road_path_id", referencedColumnName = "id")
    private Road_paths road_path;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skills skill;

    
    private Timestamp created_at;
    private Timestamp updated_at;
}
