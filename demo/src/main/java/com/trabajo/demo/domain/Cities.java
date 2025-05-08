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
@Table(name = "cities")
@Getter
@Setter
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "states_id",referencedColumnName = "id")
    private States states;
    @ManyToOne
    @JoinColumn(name = "state_abbreviation",referencedColumnName = "abbreviation")
    private States state_abbreviation;

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @NotNull
    @Size(max = 50)
    private String name_city;

    @OneToMany(mappedBy = "city")
    private List<Schools> schools;

    @OneToMany(mappedBy = "city")
    private List<Students> students;

    public Cities() {
    }

    public Cities(Long id, States states, States state_abbreviation, Timestamp createdAt, Timestamp updatedAt, String name_city) {
        this.id = id;
        this.states = states;
        this.state_abbreviation = state_abbreviation;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name_city = name_city;
    }
}
