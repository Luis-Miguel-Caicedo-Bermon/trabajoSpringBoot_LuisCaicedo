package com.trabajo.demo.infrastructure.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.trabajo.demo.application.service.RolService;
import com.trabajo.demo.domain.Role;
import com.trabajo.demo.domain.dto.RoleDto;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public boolean newRole(RoleDto name) {
        if (rolRepository.findByName(name.getName()).isPresent()) {
            return false;
        }
        Role role = new Role();
        role.setName(name.getName());
        rolRepository.save(role);
        return true;
    }

    @Override
    public List<Role> findAllRoles() {
        return rolRepository.findAll();
    }

    @Override
    public boolean updateRole(RoleDto roleDto) {
        Optional<Role> r = rolRepository.findById(roleDto.getId());
        if (!r.isPresent()) {
            return false;
        }
        Role role = r.get();
        role.setName(roleDto.getName());
        rolRepository.save(role);
        return true;
    }

    @Override
    public boolean deleteRole(Long id) {
        Optional<Role> r = rolRepository.findById(id);
        if (!r.isPresent()) {
            return false;
        }
        rolRepository.deleteById(id);
        return true;
    }
    
}
