package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FISCAL")
	private String idFiscal;

	private String marca;

	@Column(name="RAZON_SOCIAL")
	private String razonSocial;

	//bi-directional many-to-one association to Automovil
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="EMP_MAT_PAIS", referencedColumnName="MAT_PAIS"),
		@JoinColumn(name="EMP_MATRICULA", referencedColumnName="MATRICULA")
		})
	private Automovil automovil;

	public Empresa() {
	}

	public String getIdFiscal() {
		return this.idFiscal;
	}

	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Automovil getAutomovil() {
		return this.automovil;
	}

	public void setAutomovil(Automovil automovil) {
		this.automovil = automovil;
	}

}