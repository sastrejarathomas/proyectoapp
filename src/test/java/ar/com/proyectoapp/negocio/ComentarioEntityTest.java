package ar.com.proyectoapp.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.com.proyectoapp.negocios.Comentario;

public class ComentarioEntityTest {

	@Test
	public void deberiaCrearComentarioValido() {
	    Comentario comentario = new Comentario("Muy buena receta", 8);

	    assertEquals("Muy buena receta", comentario.getResena());
	    assertEquals(8, comentario.getPuntuacion());
	    
	}
	    
	    @Test
	    public void noPermiteResenaVacia() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Comentario("", 5);
	        });
	    }
	    
	    @Test
	    public void noPermiteResenaNull() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Comentario(null, 5);
	        });
	    }
	    
	    @Test
	    public void noPermitePuntuacionMenorA1() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Comentario("Comentario", 0);
	        });
	    }
	    
	    
	    
}	    
	
	

