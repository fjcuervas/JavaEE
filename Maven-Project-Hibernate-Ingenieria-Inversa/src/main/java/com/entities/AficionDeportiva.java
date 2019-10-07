package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the aficion_deportiva database table.
 * 
 */
@Entity
@Table(name="aficion_deportiva")
@NamedQuery(name="AficionDeportiva.findAll", query="SELECT a FROM AficionDeportiva a")
public class AficionDeportiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AficionDeportivaPK id;

	@Column(name="MAYOR_LOGRO")
	private String mayorLogro;

	@Column(name="NIVEL_PREFERENCIA")
	private int nivelPreferencia;

	@Column(name="POSICION_PREFERIDA")
	private String posicionPreferida;

	//bi-directional many-to-one association to Deporte
	@ManyToOne
	@JoinColumn(name="AD_ID_DEPORTE")
	private Deporte deporte;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="AD_ID_PERSONA")
	private Persona persona;

	public AficionDeportiva() {
	}

	public AficionDeportivaPK getId() {
		return this.id;
	}

	public void setId(AficionDeportivaPK id) {
		this.id = id;
	}

	public String getMayorLogro() {
		return this.mayorLogro;
	}

	public void setMayorLogro(String mayorLogro) {
		this.mayorLogro = mayorLogro;
	}

	public int getNivelPreferencia() {
		return this.nivelPreferencia;
	}

	public void setNivelPreferencia(int nivelPreferencia) {
		this.nivelPreferencia = nivelPreferencia;
	}

	public String getPosicionPreferida() {
		return this.posicionPreferida;
	}

	public void setPosicionPreferida(String posicionPreferida) {
		this.posicionPreferida = posicionPreferida;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}