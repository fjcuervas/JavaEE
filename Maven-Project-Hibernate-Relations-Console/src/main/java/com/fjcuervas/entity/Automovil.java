package com.fjcuervas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTOMOVIL")
public class Automovil {

	//Llave compuesta por matrícula y país
	@EmbeddedId
	private AutomovilPK clave;
	
	@Column(name="FABRICANTE", length = 30)
	private String fabricante;
	
	@Column(name="MODELO", length = 30)
	private String modelo;
	
	@Column(name="ANIO")
	private String anio;
	
	@Column(name="COLOR", length = 30)
	private String color;
	
	@Column(name="KILOMETRAJE")
	private String kilometraje;

	@OneToMany(mappedBy = "automovilPatrocinado",cascade = {CascadeType.PERSIST, CascadeType.MERGE})	
	private List<Empresa> patrocinadores;
	
	public Automovil() {
		patrocinadores = new ArrayList<>();
	}

	public List<Empresa> getPatrocinadores() {
		return patrocinadores;
	}

	public void setPatrocinadores(List<Empresa> patrocinadores) {
		this.patrocinadores = patrocinadores;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}


	public AutomovilPK getClave() {
		return clave;
	}

	public void setClave(AutomovilPK clave) {
		this.clave = clave;
	}

	public Automovil(AutomovilPK clave, String fabricante, String modelo, String anio, String color, String kilometraje) {
		this.clave = clave;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.anio = anio;
		this.color = color;
		this.kilometraje = kilometraje;
		this.patrocinadores = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Automovil [clave=" + clave + ", fabricante=" + fabricante + ", modelo=" + modelo + ", anio=" + anio
				+ ", color=" + color + ", kilometraje=" + kilometraje + ", patrocinadores=" + patrocinadores + "]";
	}
}
