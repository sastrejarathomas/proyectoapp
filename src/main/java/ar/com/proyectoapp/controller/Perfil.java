package ar.com.proyectoapp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.servicios.UserServiceImp;

@Controller
public class Perfil {

    private final UserServiceImp userService;

    public Perfil(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/perfil")
    public String miPerfil(Principal principal, Model model) {

        if (principal == null) {
            return "redirect:/sesion/iniciar";
        }

        String email = principal.getName();

        Usuario usuario = userService.obtenerUsuarioPorEmail(email);

        if (usuario == null) {
             return "redirect:/sesion/iniciar";
        }

        model.addAttribute("usuario", usuario);

        return "perfil";
    }
}