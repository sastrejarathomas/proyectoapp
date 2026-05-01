package ar.com.proyectoapp.negocio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.com.proyectoapp.negocios.Ingredientes;

public class IngredientesEntityTest {

    @Test
    public void crearIngredienteValido() {
        Ingredientes ingrediente = new Ingredientes(200, "Harina", "gramos");

        assertEquals(200, ingrediente.getCantidad());
        assertEquals("Harina", ingrediente.getNombre());
        assertEquals("gramos", ingrediente.getUnidad());
    }

    @Test
    public void noPermiteCantidadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ingredientes(-100, "Harina", "gramos");
        });
    }

    @Test 
    public void noPermiteNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ingredientes(200, "", "gramos");
        });
    }

    @Test
    public void noPermiteUnidadVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ingredientes(200, "Harina", "");
        });
    }
}