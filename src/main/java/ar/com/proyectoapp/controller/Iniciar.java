package ar.com.proyectoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.repositorios.UserRepository;
import ar.com.proyectoapp.servicios.UserServiceImp;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
@Controller
@RequestMapping("/sesion")
public class Iniciar {

	private final UserServiceImp userService;

	public Iniciar(UserServiceImp userService) {
	    this.userService = userService;
	}

    @GetMapping("/iniciar")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/sigIn")
    public String cargarLogin(HttpSession session,
            @ModelAttribute LoginFormulario form) {

        String email = form.getEmail();
        String contrasena = form.getContrasena();

        Usuario usu = userService.obtenerUsuarioPorEmail(email);


        SecurityContext contexto = SecurityContextHolder.getContext();

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                email, contrasena);

        contexto.setAuthentication(authentication);

        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                contexto);

        return "redirect:/principal";
    }
    }
    
