package ar.com.proyectoapp.negocio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.com.proyectoapp.negocios.Receta;
import ar.com.proyectoapp.negocios.Usuario;

public class RecetasEntityTest {


	    @Test
	    public void crearRecetaValida() {
    Receta receta = new Receta("Torta de chocolate", 60);

	        assertEquals("Torta de chocolate", receta.getNombre());
	        assertEquals(60, receta.getDuracion());
	    }

	    @Test
	    public void noPermiteDuracionNegativa() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            new Receta("Torta", -10);
	        });
	    }

	    

	    }

