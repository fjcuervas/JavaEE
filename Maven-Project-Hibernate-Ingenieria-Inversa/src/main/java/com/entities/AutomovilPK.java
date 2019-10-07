package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the automovil database table.
 * 
 */
@Embeddable
public class AutomovilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="MAT_PAIS")
	private String matPais;

	private String matricula;

	public AutomovilPK() {
	}
	public String getMatPais() {
		return this.matPais;
	}
	public void setMatPais(String matPais) {
		this.matPais = matPais;
	}
	public String getMatricula() {
		return this.matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AutomovilPK)) {
			return false;
		}
		AutomovilPK castOther = (AutomovilPK)other;
		return 
			this.matPais.equals(castOther.matPais)
			&& this.matricula.equals(castOther.matricula);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matPais.hashCode();
		hash = hash * prime + this.matricula.hashCode();
		
		return hash;
	}
}