package ar.com.proyectoapp.dtos;

public class UserDto {

	private String nombre;
	private int edad;
	

	public UserDto() {
	}

	public UserDto(String nombre, int edad, String email) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
