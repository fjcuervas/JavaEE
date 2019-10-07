package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the aficion_deportiva database table.
 * 
 */
@Embeddable
public class AficionDeportivaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="AD_ID_DEPORTE", insertable=false, updatable=false)
	private String adIdDeporte;

	@Column(name="AD_ID_PERSONA", insertable=false, updatable=false)
	private int adIdPersona;

	@Column(name="NUMERO_AFICION")
	private int numeroAficion;

	public AficionDeportivaPK() {
	}
	public String getAdIdDeporte() {
		return this.adIdDeporte;
	}
	public void setAdIdDeporte(String adIdDeporte) {
		this.adIdDeporte = adIdDeporte;
	}
	public int getAdIdPersona() {
		return this.adIdPersona;
	}
	public void setAdIdPersona(int adIdPersona) {
		this.adIdPersona = adIdPersona;
	}
	public int getNumeroAficion() {
		return this.numeroAficion;
	}
	public void setNumeroAficion(int numeroAficion) {
		this.numeroAficion = numeroAficion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AficionDeportivaPK)) {
			return false;
		}
		AficionDeportivaPK castOther = (AficionDeportivaPK)other;
		return 
			this.adIdDeporte.equals(castOther.adIdDeporte)
			&& (this.adIdPersona == castOther.adIdPersona)
			&& (this.numeroAficion == castOther.numeroAficion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.adIdDeporte.hashCode();
		hash = hash * prime + this.adIdPersona;
		hash = hash * prime + this.numeroAficion;
		
		return hash;
	}
}