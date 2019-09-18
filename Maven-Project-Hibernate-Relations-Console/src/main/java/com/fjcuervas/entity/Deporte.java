package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPORTE")
public class Deporte {

	@Id
	@Column(name = "ID_DEPORTE", length = 12)
	private String idDeporte;
	
	@Column(name = "NOMBRE", length = 30)
	private String nombre;
	
	@Column(name = "DESCRIPCION", length = 30)
	private String descripcion;

	public String getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(String idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Deporte [idDeporte=" + idDeporte + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	public Deporte(String idDeporte, String nombre, String descripcion) {
		this.idDeporte = idDeporte;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Deporte() {
	}
	
}
