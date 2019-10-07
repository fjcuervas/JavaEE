package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parking database table.
 * 
 */
@Entity
@NamedQuery(name="Parking.findAll", query="SELECT p FROM Parking p")
public class Parking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PARKING")
	private int idParking;

	private String efificio;

	private String piso;

	//bi-directional one-to-one association to Persona
	@OneToOne
	@JoinColumn(name="PARK_ID_PERSONA")
	private Persona persona;

	public Parking() {
	}

	public int getIdParking() {
		return this.idParking;
	}

	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}

	public String getEfificio() {
		return this.efificio;
	}

	public void setEfificio(String efificio) {
		this.efificio = efificio;
	}

	public String getPiso() {
		return this.piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}