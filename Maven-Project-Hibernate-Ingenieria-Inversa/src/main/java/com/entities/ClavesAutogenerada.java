package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the claves_autogeneradas database table.
 * 
 */
@Entity
@Table(name="claves_autogeneradas")
@NamedQuery(name="ClavesAutogenerada.findAll", query="SELECT c FROM ClavesAutogenerada c")
public class ClavesAutogenerada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TABLA")
	private String idTabla;

	@Column(name="NEXT_VALUE")
	private BigInteger nextValue;

	public ClavesAutogenerada() {
	}

	public String getIdTabla() {
		return this.idTabla;
	}

	public void setIdTabla(String idTabla) {
		this.idTabla = idTabla;
	}

	public BigInteger getNextValue() {
		return this.nextValue;
	}

	public void setNextValue(BigInteger nextValue) {
		this.nextValue = nextValue;
	}

}