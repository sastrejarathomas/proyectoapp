package ar.com.proyectoapp.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.proyectoapp.dtos.UserDto;
import ar.com.proyectoapp.servicios.UserServiceImp;

@RestController
public class UserAPIRestService {

    @Autowired
    private UserServiceImp service;

    @GetMapping("/api/userdto")
    public ResponseEntity<List<UserDto>> list() {

        List<UserDto> usuarios = service.listAll();

        return ResponseEntity.ok(usuarios);
    }
}
