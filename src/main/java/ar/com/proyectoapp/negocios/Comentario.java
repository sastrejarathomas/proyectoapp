package ar.com.proyectoapp.negocios;

public class Comentario {
	
	private String resena ;
	private int puntuacion ;
	
	public Comentario() {
    }

    public Comentario(String resena, int puntuacion) {
    	
    	if (resena == null || resena.trim().isEmpty()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía");
        }

        if (puntuacion < 1 || puntuacion > 10) {
            throw new IllegalArgumentException("La puntuación debe ser entre 1 y 10");
        }
    	
        this.resena = resena;
        this.puntuacion = puntuacion;
    }

    private void validarResena(String resena) {
        if (resena == null || resena.trim().isEmpty()) {
            throw new IllegalArgumentException("La reseña no puede estar vacía");
        }
    }

    private void validarPuntuacion(int puntuacion) {
        if (puntuacion < 1 || puntuacion > 10) {
            throw new IllegalArgumentException("La puntuación debe ser entre 1 y 10");
        }
    }
    
    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void interactuarConPersonas() {
        System.out.println("Interactuando con otros usuarios");
    }

    public void escribirMensaje() {
        System.out.println("Comentario escrito: " + resena);
    }
	
}
