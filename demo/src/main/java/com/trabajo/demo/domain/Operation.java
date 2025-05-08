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
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "operations")
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean permit_all;

    @ManyToOne
    @JoinColumn(name = "module_id",referencedColumnName = "id")
    private Module module;

    private String http_method;

    private String name;

    private String path;

    @OneToMany(mappedBy = "operation")
    private List<GrantedPermission> granted_permissions;

    public Operation() {
    }

    public Operation(Long id, boolean permit_all, Module module, String http_method, String name, String path) {
        this.id = id;
        this.permit_all = permit_all;
        this.module = module;
        this.http_method = http_method;
        this.name = name;
        this.path = path;
    }
}
