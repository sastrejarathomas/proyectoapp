package proyectoapp;

import java.util.ArrayList;
import java.util.List;


public class Receta {

	private String nombre ;
    private int duracion ;
    
    private List<Ingredientes> ingredientes;
    private List<Pasos> pasos;
    private List<Comentario> comentarios;

  
    public Receta() {
        this.ingredientes = new ArrayList<>();
        this.pasos = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

   
    public Receta(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.ingredientes = new ArrayList<>();
        this.pasos = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public List<Ingredientes> getIngredientes() {
        return ingredientes;
    }

    public List<Pasos> getPasos() {
        return pasos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    
    public void cocinar() {
        System.out.println("Cocinando receta: " + nombre);
    }

    public void seguirPasos() {
        System.out.println("Siguiendo pasos de la receta");
    }

    public void buscar() {
        System.out.println("Buscando receta..");
    }

   
    public void agregarIngrediente() {
     
    }

    public void agregarPaso() {
       
    }

    public void agregarComentario() {
       
    }
  
	
}
