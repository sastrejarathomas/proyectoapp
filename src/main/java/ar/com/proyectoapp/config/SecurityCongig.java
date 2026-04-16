package ar.com.proyectoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import ar.com.proyectoapp.api.rest.LoginAPIRestService;
import ar.com.proyectoapp.config.filters.JWTAuthorizationFilter;
import ar.com.proyectoapp.enums.Permiso;

@Configuration
@EnableWebSecurity
public class SecurityCongig {
	@Autowired
	private JWTAuthorizationFilter jwtfilter;
	
	
	
	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
		
		return http.securityMatcher("/api/**")
				.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(request -> request.requestMatchers(LoginAPIRestService.API_LOGIN_URL).permitAll() .anyRequest().authenticated())
				.csrf(csrt -> csrt.disable())
				.addFilterAfter(this.jwtfilter, BasicAuthenticationFilter.class)
				.build();
	
	}
	
	
	@Bean
	public SecurityFilterChain webFilterChain(HttpSecurity http) throws Exception {
		
		return http.securityMatcher("/**")
				.sessionManagement(session  -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
				.authorizeHttpRequests(auth -> auth
					    .requestMatchers("/css/**", "/fonts/**", "/images/**", "/js/**").permitAll()
					    .requestMatchers("/sesion/iniciar","/sesion/signIn", "/usuario/crear", "/usuario/guardar").permitAll()
					    .requestMatchers("/crear","/guardado").hasRole(Permiso.COCINERO.name())
					    .anyRequest().authenticated())
				        .formLogin(form -> form
	                    .loginPage("/sesion/iniciar"))
						.build();
							
			
	}
	}
	

