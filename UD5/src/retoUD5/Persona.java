package retoUD5;

import java.io.Serializable;

// Es necesario implementar Serializable para poder escribir objetos Persona en el fichero

public class Persona implements Serializable {
	private String nombre;
	private int edad;
	private String direccion;
	private int telefono;
	
	public Persona() {
	}

	public Persona(String nombre, int edad, String direccion, int telefono) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", direccion=" + direccion + ", telefono=" + telefono
				+ "]";
	}
	
	

}
