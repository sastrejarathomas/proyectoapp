package ar.com.proyectoapp.servicios;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import ar.com.proyectoapp.negocios.Usuario;

@Service
public class JWTServiceImp implements JWTService {

    private static final String KEY_EMAIL = "email"; 
    private static final String KEY_AUTHORIZATION = "authorization";


    @Value("${jwt.secret.password}")
    private String secretPassword;
    
    
    @Override
    public String buildToken(Usuario usuario) 
    { 
        return JWT.create()
                .withKeyId("my-app-" + usuario.getId())
                .withExpiresAt(Instant.now().plusSeconds(190))
                .withClaim(KEY_EMAIL, usuario.getEmail()) 
                .withClaim(KEY_AUTHORIZATION, obtenerPermisosUsuarios(usuario))
                .sign(Algorithm.HMAC512(this.secretPassword));
    }


	@Override
	public boolean isValidToken(String token) {
		  DecodedJWT decodedToken = JWT.decode(token);
		  
		  Instant instant = decodedToken.getExpiresAtAsInstant();

		  return Instant.now().isBefore(instant);
	}
    
    public Authentication buildAuthentication(String token) {
        DecodedJWT decodedToken = JWT.decode(token);

        String id = decodedToken.getKeyId();
        String email = decodedToken.getClaim(KEY_EMAIL).asString();
        Claim claim = decodedToken.getClaim(KEY_AUTHORIZATION);

        List<String> permisos = claim.asList(String.class);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                email, null, convertirPermisos(permisos));

        return auth;
    }

    private List<String> obtenerPermisosUsuarios(Usuario usuario) {
        List<String> permisos = new ArrayList<>();

        for (GrantedAuthority auth : usuario.getAuthorities()) {
            permisos.add(auth.getAuthority());
        }

        return permisos;
    }

    private List<GrantedAuthority> convertirPermisos(List<String> permisos) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String permiso : permisos) {
            authorities.add("ROLE_" + auth.getAuthority()); 
        }

        return authorities;
    }


	
	}
