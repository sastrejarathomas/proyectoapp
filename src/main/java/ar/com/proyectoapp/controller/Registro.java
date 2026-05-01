package ar.com.proyectoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.servicios.UserServiceImp;

@Controller
@RequestMapping("/usuario")
public class Registro {

	private UserServiceImp userService;

	public Registro(UserServiceImp userService) {
	    this.userService = userService;
	}
   
    
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute Usuario usuario) {

        userService.crearUsuario(usuario);

        return "redirect:/principal";
    }
    }

