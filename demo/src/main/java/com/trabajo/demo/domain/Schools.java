package com.trabajo.demo.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schools")
@Getter
@Setter
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private Cities city;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull
    @Size(max = 50)
    private String descriptionSchool;

    @NotNull
    @Size(max = 50)
    private String headmasterSchool;

    @NotNull
    @Size(max = 80)
    private String cellphoneSchool;

    @NotNull
    @Size(max = 80)
    private String emailSchool;

    @OneToMany(mappedBy = "school")
    private List<Students> students;


    public Schools() {
    }

    public Schools(Long id, Cities city, LocalDateTime createdAt, LocalDateTime updatedAt, String descriptionSchool,
                   String headmasterSchool, String cellphoneSchool, String emailSchool) {
        this.id = id;
        this.city = city;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.descriptionSchool = descriptionSchool;
        this.headmasterSchool = headmasterSchool;
        this.cellphoneSchool = cellphoneSchool;
        this.emailSchool = emailSchool;
    }
}