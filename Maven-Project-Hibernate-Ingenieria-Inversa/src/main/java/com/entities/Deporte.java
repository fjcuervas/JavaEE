package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the deporte database table.
 * 
 */
@Entity
@NamedQuery(name="Deporte.findAll", query="SELECT d FROM Deporte d")
public class Deporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_DEPORTE")
	private String idDeporte;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to AficionDeportiva
	@OneToMany(mappedBy="deporte")
	private List<AficionDeportiva> aficionDeportivas;

	public Deporte() {
	}

	public String getIdDeporte() {
		return this.idDeporte;
	}

	public void setIdDeporte(String idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<AficionDeportiva> getAficionDeportivas() {
		return this.aficionDeportivas;
	}

	public void setAficionDeportivas(List<AficionDeportiva> aficionDeportivas) {
		this.aficionDeportivas = aficionDeportivas;
	}

	public AficionDeportiva addAficionDeportiva(AficionDeportiva aficionDeportiva) {
		getAficionDeportivas().add(aficionDeportiva);
		aficionDeportiva.setDeporte(this);

		return aficionDeportiva;
	}

	public AficionDeportiva removeAficionDeportiva(AficionDeportiva aficionDeportiva) {
		getAficionDeportivas().remove(aficionDeportiva);
		aficionDeportiva.setDeporte(null);

		return aficionDeportiva;
	}

}