package com.trabajo.demo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private Long id;
    private Long role_id;
    private String name;
    private String password;
    private String username;

    public UserRequest() {
    }
    public UserRequest(Long role_id, String name, String password, String username) {
        this.role_id = role_id;
        this.name = name;
        this.password = password;
        this.username = username;
    }
    
}
