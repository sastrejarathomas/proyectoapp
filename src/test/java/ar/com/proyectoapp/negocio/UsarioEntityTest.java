package ar.com.proyectoapp.negocio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ar.com.proyectoapp.negocios.Usuario;

public class UsarioEntityTest {

    @Test
    public void crearUsuarioValido() {

        Usuario usuario = new Usuario("Thomas",25, "thomassastre@gmail.com", "23082006");

        assertEquals("Thomas", usuario.getNombre());
        assertEquals(25, usuario.getEdad());
        assertEquals("23082006", usuario.getContrasena());
        assertEquals("thomassastre@gmail.com", usuario.getEmail());
    }

    @Test
    public void noPermiteEdadNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", -1, "thomassastre@gmail.com", "23082006");
        });
    }

    @Test
    public void noPermiteEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", 25, "thomassastregmail.com", "23082006");
        });
    }

    @Test
    public void noPermiteNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("", 25, "thomassastre@gmail.com", "23082006");
        });
    }

    @Test
    public void noPermiteContrasenaVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", 25, "thomassastre@gmail.com", "");
        });
    }

    @Test
    public void noPermiteContrasenaMuyCorta() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", 25, "thomassastre@gmail.com", "123");
        });
    }

    @Test
    public void emailDebeTenerArroba() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", 25, "thomasgmail.com", "1234");
        });
    }
    
    @Test
    public void noDebePermitirContrasenaEncadena() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Thomas", 25, "thomas@gmail.com", "12345678");
        });

    }
    
    
    
}


