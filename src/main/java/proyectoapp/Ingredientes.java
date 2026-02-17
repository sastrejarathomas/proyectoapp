package proyectoapp;

public class Ingredientes {

	private String nombre ;
	private int cantidad ;
	private String unidad ;
	
	
public class Ingrediente {

	    
	    private String nombre;
	    private int cantidad;
	    private String unidad;

	    
        public Ingrediente() {
	    }

	    
        public Ingrediente(String nombre, int cantidad, String unidad) {
	        this.nombre = nombre;
	        this.cantidad = cantidad;
	        this.unidad = unidad;
	    }

	   
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    public void setCantidad(int cantidad) {
	        this.cantidad = cantidad;
	    }

	    public String getUnidad() {
	        return unidad;
	    }

	    public void setUnidad(String unidad) {
	        this.unidad = unidad;
	    }

	   
	    public void mezclarIngredientes() {
	        System.out.println("Mezclando ingrediente: " + nombre);
	    }	
	
}

}
