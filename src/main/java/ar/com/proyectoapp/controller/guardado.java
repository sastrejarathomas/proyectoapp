package ar.com.proyectoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class guardado {

	 @GetMapping("/guardado")
	    public String mostrarGuardado() {
	        return "guardado";
}
}
