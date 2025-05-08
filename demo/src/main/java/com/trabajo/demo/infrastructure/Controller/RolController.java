package com.trabajo.demo.infrastructure.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.demo.application.service.RolService;
import com.trabajo.demo.domain.Role;
import com.trabajo.demo.domain.dto.RoleDto;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/role")
    public List<Role> findAllRole() {
        return rolService.findAllRoles();
    }
    

    @PostMapping("/role")
    public ResponseEntity<String> createNewRole(@RequestBody RoleDto name) {
        boolean created = rolService.newRole(name);
        if (created) {
            return ResponseEntity.ok("rol creaado");
        } else {
            return ResponseEntity.badRequest().body("no se pude crear el rol");
        }
    }

    @PutMapping("/role/{id}")
    public ResponseEntity<String> updateRole(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        roleDto.setId(id);
        boolean updated = rolService.updateRole(roleDto);
        if (updated) {
            return ResponseEntity.ok("rol actualizado");
        } else {
            return ResponseEntity.badRequest().body("no se pude actualizar el rol");
        }
    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        boolean deleted = rolService.deleteRole(id);
        if (deleted) {
            return ResponseEntity.ok("rol eliminado");
        } else {
            return ResponseEntity.badRequest().body("no se pude eliminar el rol");
        }
    }
    
}
