package ar.com.proyectoapp.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.servicios.JWTService;
import ar.com.proyectoapp.servicios.UserServiceImp;




@RestController
public class LoginAPIRestService {

    public static final String API_LOGIN_URL = "/api/login";

    @Autowired
    private UserServiceImp userservice;
    
    @Autowired
    private JWTService jwtService ;

    @PostMapping(value = API_LOGIN_URL,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> login(@RequestBody LoginApiFormulario formulario) {
        Usuario usuario = userservice.obtenerUsuarioPorEmail(formulario.getEmail());
        ResponseEntity<Object> resultado;
		if(usuario == null) {
        	resultado = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();	
        } else {
        	String token = this.jwtService.buildToken(usuario);
        	resultado = ResponseEntity.ok(token);
        }
        
        return resultado;
    }
}