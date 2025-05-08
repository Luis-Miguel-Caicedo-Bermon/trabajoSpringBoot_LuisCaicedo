package com.trabajo.demo.application.service;

import java.util.List;

import com.trabajo.demo.domain.Role;
import com.trabajo.demo.domain.dto.RoleDto;

public interface RolService {
    boolean newRole(RoleDto name);
    List<Role> findAllRoles();
    boolean updateRole(RoleDto roleDto);

    boolean deleteRole(Long id);
}
