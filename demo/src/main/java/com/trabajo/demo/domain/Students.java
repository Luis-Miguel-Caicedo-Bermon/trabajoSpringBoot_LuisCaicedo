package com.trabajo.demo.domain;

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
@Table(name = "students")
@Getter
@Setter
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private Cities city;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "id")
    private Schools school;

    @Size(max = 30)
    private String cellphone;

    @NotNull
    @Size(max = 50)
    private String email;

    @NotNull
    @Size(max = 50)
    private String firstname;

    @NotNull
    @Size(max = 50)
    private String lastname;

    @OneToMany(mappedBy = "student")
    private List<Exams> Exams;

    public Students() {
    }

    public Students(Long id, int age, Cities city, Schools school, String cellphone, String email, String firstname, String lastname) {
        this.id = id;
        this.age = age;
        this.city = city;
        this.school = school;
        this.cellphone = cellphone;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }
}