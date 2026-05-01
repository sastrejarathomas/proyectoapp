package ar.com.proyectoapp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.proyectoapp.negocios.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByEmail(String email);
	
}