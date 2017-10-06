package celsawebapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {
	@Id
	@Column(name = "dni")
	private String dni;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "adeuda")
	private String adeuda;
	
	public Alumno() {
		super();
	}

	public Alumno(String dni, String apellido, String nombre, String adeuda) {
		super();
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.adeuda = adeuda;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAdeuda() {
		return adeuda;
	}

	public void setAdeuda(String adeuda) {
		this.adeuda = adeuda;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", adeuda=" + adeuda + "]";
	}

	
	
	
	
}
