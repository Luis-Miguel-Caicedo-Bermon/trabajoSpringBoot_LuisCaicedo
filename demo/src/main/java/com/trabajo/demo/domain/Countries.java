package com.trabajo.demo.domain;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity@Table(name = "countries")@Getter@Setter
public class Countries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Size(max = 50)
    private String country_name;

    @OneToMany(mappedBy = "countries")
    private List<States> states;

    public Countries() {
    }

    public Countries(Long id, Timestamp createdAt, Timestamp updatedAt, String country_name) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.country_name = country_name;
    }
}
