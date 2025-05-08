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

@Entity@Table(name = "countries")@Getter@Setter
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Countries countries;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @NotNull
    @Size(max = 50)
    private String abbreviation;

    @NotNull
    @Size(max = 50)
    private String state_name;

    @OneToMany(mappedBy = "states")
    private List<Cities> cities;

    public States() {
    }

   public States(Long id, Countries countries, Timestamp createdAt, Timestamp updatedAt, String abbreviation, String state_name) {
        this.id = id;
        this.countries = countries;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.abbreviation = abbreviation;
        this.state_name = state_name;
    }
}
