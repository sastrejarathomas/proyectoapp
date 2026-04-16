package ar.com.proyectoapp.servicios;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.proyectoapp.dtos.UserDto;
import ar.com.proyectoapp.negocios.Usuario;
import ar.com.proyectoapp.repositorios.UserRepository;

@Service
public class UserServiceImp {

	@Autowired
	private UserRepository userrepository;
	
	private ModelMapper mapper = new ModelMapper();
	
	public Usuario crearUsuario(Usuario usuario) {
		return userrepository.save(usuario);
	}

	
	public List<UserDto> listAll() {

	    List<Usuario> usuarios = this.userrepository.findAll();
	    List<UserDto> userDto = new ArrayList<>();

	    for (Usuario user : usuarios) {
	        
			userDto.add(mapper.map(user, UserDto.class));
	    }

	    return userDto;
	}
	
	public Usuario obtenerUsuarioPorEmail(String email) {
	    return userrepository.findByEmail(email);
	}
}