package ar.com.proyectoapp.negocios;

public class Ingredientes {

    private String nombre;
    private int cantidad;
    private String unidad;

    public Ingredientes() {
    }

    public Ingredientes (int cantidad, String nombre, String unidad) {

        validarCantidad(cantidad);
        validarNombre(nombre);
        validarUnidad(unidad);

        this.cantidad = cantidad;
        this.nombre = nombre;
        this.unidad = unidad;
    }
    
    private void validarCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarUnidad(String unidad) {
        if (unidad == null || unidad.trim().isEmpty()) {
            throw new IllegalArgumentException("La unidad no puede estar vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }


    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        validarCantidad(cantidad);
        this.cantidad = cantidad;
    }

    public void setUnidad(String unidad) {
        validarUnidad(unidad);
        this.unidad = unidad;
    }

    public void mezclarIngredientes() {
        System.out.println("Mezclando ingrediente: " + nombre);
    }
}