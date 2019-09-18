package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NombreCompleto {
	
	@Column(name = "NOMBRE", length = 50)
	private String nombre;
	
	@Column(name = "SEGUNDO_NOMBRE", length = 150)
	private String segundoNombre;
	
	@Column(name = "APELLIDO1", length = 100)
	private String apellido1;
	
	@Column(name = "APELLIDO2", length = 100)
	private String apellido2;
	
	public NombreCompleto(String nombre, String segundoNombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.segundoNombre = segundoNombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}

	public NombreCompleto() {
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Override
	public String toString() {
		return "NombreCompleto [nombre=" + nombre + ", segundoNombre=" + segundoNombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + "]";
	}

	
}
