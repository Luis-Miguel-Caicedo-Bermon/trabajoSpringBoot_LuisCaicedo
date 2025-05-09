package com.trabajo.demo.infrastructure.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;

import com.trabajo.demo.application.service.UserService;
import com.trabajo.demo.domain.Role;
import com.trabajo.demo.domain.User;
import com.trabajo.demo.domain.dto.UserRequest;
import com.trabajo.demo.infrastructure.error.UserNotFoundException;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;
    private final RolRepository rolRepository;

    public UserServiceimpl(UserRepository userRepository, RolRepository rolRepository) {
        this.rolRepository = rolRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Boolean newUser(UserRequest user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return false;
        }
        Optional<Role> role = rolRepository.findById(user.getRole_id());
        if (!role.isPresent()) {
            return false;
        }

        User newUser = new User();
        newUser.setRole(role.get());
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return true;
    }

    @Override
    public User updateUserById(UserRequest user) {
        Optional<User> u = userRepository.findById(user.getId());

        if (!u.isPresent()) {
            throw new UserNotFoundException("No se encontró el usuario solicitado",HttpStatus.NOT_FOUND);
        }
        Optional<Role> r = Optional.empty();
        if (user.getRole_id() != null) {

            r = rolRepository.findById(user.getRole_id());

            if (!r.isPresent()) {
                throw new UserNotFoundException("No se encontró el rol solicitado", HttpStatus.NOT_FOUND);
            }
        }
        User usuario = userRepository.findById(user.getId()).get();

        if (user.getName()!=null) {
            usuario.setName(user.getName());
        }
        if (user.getPassword()!=null) {
            usuario.setPassword(user.getPassword());
        }
        if (user.getUsername()!=null) {
            usuario.setUsername(user.getUsername());
        }
        if (user.getRole_id()!=null) {
            usuario.setRole(r.get());
        }

        return userRepository.save(usuario);
    }

    
    
}
