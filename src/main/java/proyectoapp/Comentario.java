package proyectoapp;

public class Comentario {
	
	private String resena ;
	private int puntuacion ;
	
	public Comentario() {
    }

    public Comentario(String resena, int puntuacion) {
        this.resena = resena;
        this.puntuacion = puntuacion;
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
