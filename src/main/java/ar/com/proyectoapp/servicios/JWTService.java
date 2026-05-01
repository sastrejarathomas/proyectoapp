package ar.com.proyectoapp.servicios;

import org.springframework.security.core.Authentication;

import ar.com.proyectoapp.negocios.Usuario;

public interface JWTService {

	public String PREFIX_TOKEN = "Bearer";
	
	public String buildToken(Usuario usuario);
	
	
	public boolean isValidToken(String token);
	
	Authentication buildAuthentication(String token);
	
}
