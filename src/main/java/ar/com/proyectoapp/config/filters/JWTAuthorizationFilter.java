package ar.com.proyectoapp.config.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import ar.com.proyectoapp.servicios.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private JWTService jwtservice; 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if (existeTokenJWT(request)) {
			String token = fetchToken(request);
			
			if(isValidToken(token)) {
				Authentication auth =  jwtservice.buildAuthentication(token);
				
				SecurityContext contexto = SecurityContextHolder.getContext();
				contexto.setAuthentication(auth);
		} else {
			
			SecurityContextHolder.clearContext();
		}
		
		}
		
		filterChain.doFilter(request, response); 
	}


	private boolean existeTokenJWT(HttpServletRequest request) {
			String value = request.getHeader(HttpHeaders.AUTHORIZATION);
		return (value != null &&  value.startsWith(JWTService.PREFIX_TOKEN));
	}
	
	private String fetchToken(HttpServletRequest request) {
		String value = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		String[] segmentos = value.split(" ");
		
		return segmentos[1];
	}
	
	private boolean isValidToken(String token) {
		return jwtservice.isValidToken(token);
			
	}
}
