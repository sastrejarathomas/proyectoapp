package ar.com.proyectoapp.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.proyectoapp.App;
import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.repositorios.UserRepository;
import ar.com.proyectoapp.servicios.UserServiceImp;

@SpringBootTest
public class UsuarioServiceIntegrationTest {

    @Autowired
    private UserServiceImp usuarioService;

    @Test
    public void deberiaCrearUsuarioCorrectamente() {

        Usuario usuario = new Usuario();
        usuario.setNombre("simon");
        usuario.setEmail("simon@gmail.com");
        usuario.setEdad(25);
        usuario.setContrasena("18022011");

        Usuario usuarioGuardado = usuarioService.crearUsuario(usuario);

        assertNotNull(usuarioGuardado.getId());
        assertEquals("simon", usuarioGuardado.getNombre());
    }
    @Test
    public void noDebePermitirEmailsDuplicados() {

        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Juan");
        usuario1.setEdad(30);
        usuario1.setEmail("juangimenez@gmail.com");
        usuario1.setContrasena("43681290");

        usuarioService.crearUsuario(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Pedro");
        usuario2.setEdad(28);
        usuario2.setEmail("juangimenez@gmail.com"); 
        usuario2.setContrasena("96743215");

        assertThrows(Exception.class, () -> {
            usuarioService.crearUsuario(usuario2);
        });
    }
  
   
    
    
}
