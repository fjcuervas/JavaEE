package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING")
public class Parking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PARKING")
	private int idParking;
	
	@Column(name = "EFIFICIO", length = 100)
	private String edificio;
	
	@Column(name = "PISO", length = 100)
	private String piso;
	
	//Relación 1 a 1 Bidireccional
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARK_ID_PERSONA", referencedColumnName = "ID_PERSONA")
	private Persona personaAsignada;

	public int getIdParking() {
		return idParking;
	}

	public void setIdParking(int idParking) {
		this.idParking = idParking;
	}

	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	public String getPiso() {
		return piso;
	}

	public void setPiso(String piso) {
		this.piso = piso;
	}

	public Persona getPersonaAsignada() {
		return personaAsignada;
	}

	public void setPersonaAsignada(Persona personaAsignada) {
		this.personaAsignada = personaAsignada;
	}

	public Parking(String edificio, String piso) {
		this.edificio = edificio;
		this.piso = piso;
	}

	public Parking() {
	}


	public Parking(String edificio, String piso, Persona personaAsignada) {
		this.edificio = edificio;
		this.piso = piso;
		this.personaAsignada = personaAsignada;
	}

	@Override
	public String toString() {
		return "Parking [idParking=" + idParking + ", edificio=" + edificio + ", piso=" + piso + ", personaAsignada=]";
		
//		return "Parking [idParking=" + idParking + ", edificio=" + edificio + ", piso=" + piso + ", personaAsignada="
//		+ personaAsignada.getNombreCompleto() + "]";		
	}
}
