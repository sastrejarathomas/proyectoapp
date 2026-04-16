package ar.com.proyectoapp.negocios;

public class Pasos {

	private String instrucciones ;
	private int orden ;
	
	 public Pasos() {
	    }

	    public Pasos(String instrucciones, int orden) {
	        this.instrucciones = instrucciones;
	        this.orden = orden;
	    }

	    public String getInstrucciones() {
	        return instrucciones;
	    }

	    public void setInstrucciones(String instrucciones) {
	        this.instrucciones = instrucciones;
	    }

	    public int getOrden() {
	        return orden;
	    }

	    public void setOrden(int orden) {
	        this.orden = orden;
	    }
	}
	

