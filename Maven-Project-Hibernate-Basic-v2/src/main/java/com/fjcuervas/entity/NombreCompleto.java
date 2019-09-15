package com.fjcuervas.entity;

import javax.persistence.Embeddable;

@Embeddable
public class NombreCompleto {

	private String nombre;
	private String apellido1;
	private String apellido2;
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public String getApellido2() {
		return apellido2;
	}
	
	public NombreCompleto() {
	}
	
	@Override
	public String toString() {
		return "NombreCompleto [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + "]";
	}

	public NombreCompleto(String nombre, String apellido1, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
	}
	
	
}
