package com.fjcuervas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AutomovilPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="MATRICULA",length = 10)
	private String matricula;
	
	@Column(name="MAT_PAIS",length = 5)
	private String matPais;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatPais() {
		return matPais;
	}

	public void setMatPais(String matPais) {
		this.matPais = matPais;
	}

	@Override
	public String toString() {
		return "AutomovilPK [matricula=" + matricula + ", matPais=" + matPais + "]";
	}

	public AutomovilPK(String matricula, String matPais) {
		this.matricula = matricula;
		this.matPais = matPais;
	}
	
	public AutomovilPK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matPais == null) ? 0 : matPais.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		AutomovilPK other = (AutomovilPK) obj;
		if (matPais == null) {
			if (other.matPais != null)
				return false;
		} else if (!matPais.equals(other.matPais))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
}
