package ar.com.proyectoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principal {

    @GetMapping("/principal")
    public String mostrarPrincipal() {
        return "principal";
    }
}