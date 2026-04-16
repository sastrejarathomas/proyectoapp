package ar.com.proyectoapp.negocios;

import java.util.ArrayList;
import java.util.List;


public class Carpeta {

	private String nombre ;
	private int duracion ;
	
	
	 private int guardado;
	    private List<Receta> recetasGuardadas;

	    public Carpeta() {
	        this.recetasGuardadas = new ArrayList<>();
	    }

	    public Carpeta(int guardado) {
	        this.guardado = guardado;
	        this.recetasGuardadas = new ArrayList<>();
	    }

	    public int getGuardado() {
	        return guardado;
	    }

	    public void setGuardado(int guardado) {
	        this.guardado = guardado;
	    }

	    public List<Receta> getRecetasGuardadas() {
	        return recetasGuardadas;
	    }

	    public void guardarReceta() {
	       
	    }
	}
	
	
