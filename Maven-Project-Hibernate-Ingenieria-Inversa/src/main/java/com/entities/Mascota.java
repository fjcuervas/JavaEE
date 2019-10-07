package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mascota database table.
 * 
 */
@Entity
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m")
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_MASCOTA")
	private int idMascota;

	private String nombre;

	@Column(name="TIPO_MASCOTA")
	private String tipoMascota;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="MAS_ID_PERSONA")
	private Persona persona;

	public Mascota() {
	}

	public int getIdMascota() {
		return this.idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoMascota() {
		return this.tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}