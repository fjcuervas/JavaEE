package com.fjcuervas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AficionDeportivaPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "AD_ID_PERSONA")
	private int idPersonaFK;
	
	@Column(name = "AD_ID_DEPORTE")
	private String idDeporteFK;
	
	@Column(name = "NUMERO_AFICION")
	private int numAficion;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDeporteFK == null) ? 0 : idDeporteFK.hashCode());
		result = prime * result + idPersonaFK;
		result = prime * result + numAficion;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AficionDeportivaPK other = (AficionDeportivaPK) obj;
		if (idDeporteFK == null) {
			if (other.idDeporteFK != null)
				return false;
		} else if (!idDeporteFK.equals(other.idDeporteFK))
			return false;
		if (idPersonaFK != other.idPersonaFK)
			return false;
		if (numAficion != other.numAficion)
			return false;
		return true;
	}

	public int getIdPersonaFK() {
		return idPersonaFK;
	}

	public void setIdPersonaFK(int idPersonaFK) {
		this.idPersonaFK = idPersonaFK;
	}

	public String getIdDeporte() {
		return idDeporteFK;
	}

	public void setIdDeporte(String idDeporte) {
		this.idDeporteFK = idDeporte;
	}

	public int getNumAficion() {
		return numAficion;
	}

	public void setNumAficion(int numAficion) {
		this.numAficion = numAficion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AficionDeportivaPK [idPersonaFK=" + idPersonaFK + ", idDeporteFK=" + idDeporteFK + ", numAficion="
				+ numAficion + "]";
	}

	public AficionDeportivaPK(int idPersonaFK, String idDeporteFK, int numAficion) {
		this.idPersonaFK = idPersonaFK;
		this.idDeporteFK = idDeporteFK;
		this.numAficion = numAficion;
	}

	public AficionDeportivaPK() {
	}

}
