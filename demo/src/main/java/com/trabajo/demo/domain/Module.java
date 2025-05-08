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
@Table(name = "modules")
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String base_path;
    private String name;

    @OneToMany(mappedBy = "module")
    private List<Operation> operations;

    public Module(){

    }

    public Module(Long id, String base_path, String name) {
        this.id = id;
        this.base_path = base_path;
        this.name = name;
    }
}
