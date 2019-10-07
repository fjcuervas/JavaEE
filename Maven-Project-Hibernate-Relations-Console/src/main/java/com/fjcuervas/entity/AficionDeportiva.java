package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="AFICION_DEPORTIVA")
public class AficionDeportiva {

	@EmbeddedId
	private AficionDeportivaPK clave;
	
	@Column(name = "NIVEL_PREFERENCIA")
	private int nivelPreferencia;
	
	@Column(name = "POSICION_PREFERIDA", length = 40)
	private String posicionPreferida;
	
	@Column(name = "MAYOR_LOGRO", length = 60)
	private String mayorLogro;
	
	@ManyToOne
	@MapsId(value = "idPersonaFK") //Indicamos que este campo ya está en la llave primaria (llave derivada) y que no lo repita
	@JoinColumn(name = "AD_ID_PERSONA")
	private Persona persona;
	
	@ManyToOne
	@MapsId(value = "idDeporteFK") //Indicamos que este campo ya está en la llave primaria (llave derivada) y que no lo repita
	@JoinColumn(name = "AD_ID_DEPORTE")
	private Deporte deporte;
	


	public AficionDeportivaPK getClave() {
		return clave;
	}

	public void setClave(AficionDeportivaPK clave) {
		this.clave = clave;
	}

	public int getNivelPreferencia() {
		return nivelPreferencia;
	}

	public void setNivelPreferencia(int nivelPreferencia) {
		this.nivelPreferencia = nivelPreferencia;
	}

	public String getPosicionPreferida() {
		return posicionPreferida;
	}

	public void setPosicionPreferida(String posicionPreferida) {
		this.posicionPreferida = posicionPreferida;
	}

	public String getMayorLogro() {
		return mayorLogro;
	}

	public void setMayorLogro(String mayorLogro) {
		this.mayorLogro = mayorLogro;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public AficionDeportiva(AficionDeportivaPK clave, int nivelPreferencia, String posicionPreferida, String mayorLogro,
			Deporte deporte, Persona persona) {
		this.clave = clave;
		this.nivelPreferencia = nivelPreferencia;
		this.posicionPreferida = posicionPreferida;
		this.mayorLogro = mayorLogro;
		this.deporte = deporte;
		this.persona = persona;
	}

	public AficionDeportiva() {
	}

	@Override
	public String toString() {
		return "AficionDeportiva [clave=" + clave + ", nivelPreferencia=" + nivelPreferencia + ", posicionPreferida="
				+ posicionPreferida + ", mayorLogro=" + mayorLogro + ", deporte=" + deporte + ", persona=" + persona
				+ "]";
	}
}
