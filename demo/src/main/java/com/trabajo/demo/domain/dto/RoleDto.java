package com.trabajo.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    private Long id;
    private String name;

    public RoleDto() {
    }

    public RoleDto(String name) {
        this.name = name;
    }   

    public RoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
