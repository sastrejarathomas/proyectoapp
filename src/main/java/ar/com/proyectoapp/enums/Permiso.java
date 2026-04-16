package ar.com.proyectoapp.enums;

public enum Permiso {
	COCINERO;
	
	public String securityName() {
		return "ROLE_" + name();
	}
		
}

