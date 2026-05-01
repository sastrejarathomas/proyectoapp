package ar.com.proyectoapp.negocios;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import ar.com.proyectoapp.enums.Permiso;
import jakarta.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Enumerated(EnumType.ORDINAL)
	@ElementCollection(targetClass = Permiso.class)
	@CollectionTable(name = "PERMISOS_USUARIOS", joinColumns =  @JoinColumn(name = "USARIO_ID"))
	@Column(name = "PERMISO_ID")
	private List<Permiso> permisos	;
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String contrasena;
    
    public Usuario() {
    }

    public Usuario(String nombre, int edad, String email, String contrasena) {
    	
    	this.permisos.add(Permiso.COCINERO);
    	
        validarNombre(nombre);
        validarEdad(edad);
        validarEmail(email);
        validarContrasena(contrasena);

        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.contrasena = contrasena;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }

    private void validarEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

   
    private void validarContrasena(String contrasena) {

            if (contrasena == null || contrasena.trim().isEmpty()) {
                throw new IllegalArgumentException("La contraseña no puede estar vacía");
            }

            if (contrasena.length() < 6) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
            }
        
            if (contrasena == null || contrasena.trim().isEmpty()) {
                    throw new IllegalArgumentException("La contraseña no puede estar vacía");
                }

             if (contrasena.equals("12345678")) {
                    throw new IllegalArgumentException("La contraseña no puede ser números consecutivos");
                }
            }
            
    

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }
    

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    public void setEmail(String email) {
        validarEmail(email);
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        validarContrasena(contrasena);
        this.contrasena = contrasena;
    }

	public GrantedAuthority[] getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}