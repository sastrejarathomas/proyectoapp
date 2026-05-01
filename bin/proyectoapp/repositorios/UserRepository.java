package repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectoapp.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

}


