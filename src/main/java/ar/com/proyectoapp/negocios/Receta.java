package ar.com.proyectoapp.negocios;

import java.util.ArrayList;
import java.util.List;

public class Receta {

    private String nombre;
    private int duracion;

    private List<Ingredientes> ingredientes;
    private List<Pasos> pasos;
    private List<Comentario> comentarios;

    public Receta() {
        this.ingredientes = new ArrayList<>();
        this.pasos = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public Receta(String nombre, int duracion) {

        validarNombre(nombre);
        validarDuracion(duracion);

        this.nombre = nombre;
        this.duracion = duracion;
        this.ingredientes = new ArrayList<>();
        this.pasos = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarDuracion(int duracion) {
        if (duracion < 0) {
            throw new IllegalArgumentException("La duración no puede ser negativa");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
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

   
    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        validarDuracion(duracion);
        this.duracion = duracion;
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


    public void agregarIngrediente(Ingredientes ingrediente) {
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente no puede ser null");
        }
        ingredientes.add(ingrediente);
    }

    public void agregarPaso(Pasos paso) {
        if (paso == null) {
            throw new IllegalArgumentException("Paso no puede ser null");
        }
        pasos.add(paso);
    }

    public void agregarComentario(Comentario comentario) {
        if (comentario == null) {
            throw new IllegalArgumentException("Comentario no puede ser null");
        }
        comentarios.add(comentario);
    }
}