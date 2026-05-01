package ar.com.proyectoapp.api.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.proyectoapp.negocios.Receta;


@RestController
public class RecetAPIRestService {
	
	    @GetMapping(value = "/api/recetas") 
	    	public ResponseEntity<List<Receta>> obtenerRecetas() {

	    	    List<Receta> recetas = new ArrayList<>();

	    	    recetas.add(new Receta("Hamburguesa", 20));
	    	    recetas.add(new Receta("Pizza", 30));
	    	    recetas.add(new Receta("Pasta Italiana", 25));
	    	    recetas.add(new Receta("Ensalada Saludable", 10));

	    	    return ResponseEntity.ok(recetas);
	    }
	}


