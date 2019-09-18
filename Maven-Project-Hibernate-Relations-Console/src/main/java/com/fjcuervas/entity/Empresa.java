package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPRESA")
public class Empresa {

	@Id
	@Column(name="ID_FISCAL", length = 40)
	private String idFiscal;
	
	@Column(name="MARCA", length = 40)
	private String nombreComercial;
	
	@Column(name="RAZON_SOCIAL", length = 40)
	private String razonSocial;

	//Relación 1 a muchos con clave compuesta. El Automovil tiene una clave compuesta.
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="EMP_MATRICULA",referencedColumnName = "MATRICULA"),
		@JoinColumn(name="EMP_MAT_PAIS",referencedColumnName = "MAT_PAIS")
	})
	private Automovil automovilPatrocinado;
	
	public Empresa() {
	}
	
	public Automovil getAutomovilPatrocinado() {
		return automovilPatrocinado;
	}

	public void setAutomovilPatrocinado(Automovil automovilPatrocinado) {
		this.automovilPatrocinado = automovilPatrocinado;
	}

	public Empresa(String idFiscal, String nombreComercial, String razonSocial, Automovil automovilPatrocinado) {
		this.idFiscal = idFiscal;
		this.nombreComercial = nombreComercial;
		this.razonSocial = razonSocial;
		this.automovilPatrocinado = automovilPatrocinado;
	}

	public String getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "Empresa [idFiscal=" + idFiscal + ", nombreComercial=" + nombreComercial + ", razonSocial=" + razonSocial
				+ "]";
	}
}
