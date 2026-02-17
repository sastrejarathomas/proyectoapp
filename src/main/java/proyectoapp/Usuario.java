package proyectoapp;



public class Usuario {
	
	private String nombre ;
	private int edad ;
	private String email ;
	private String contrasena ;
	
	public Usuario() {
    }

    
    public Usuario(String nombre, int edad, String email, String contrasena) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.contrasena = contrasena;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    public void iniciarSesion() {
        System.out.println("Usuario " + nombre + " inició sesión");
    }

    public void cerrarSesion() {
        System.out.println("Usuario " + nombre + " cerró sesión");
    }

    public void crearReceta() {
        System.out.println("Usuario " + nombre + " creó una receta");
    }
}


