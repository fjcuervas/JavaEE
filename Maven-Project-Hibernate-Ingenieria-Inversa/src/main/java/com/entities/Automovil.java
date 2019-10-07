package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the automovil database table.
 * 
 */
@Entity
@NamedQuery(name="Automovil.findAll", query="SELECT a FROM Automovil a")
public class Automovil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AutomovilPK id;

	private String anio;

	private String color;

	private String fabricante;

	private String kilometraje;

	private String modelo;

	//bi-directional many-to-one association to Empresa
	@OneToMany(mappedBy="automovil")
	private List<Empresa> empresas;

	public Automovil() {
	}

	public AutomovilPK getId() {
		return this.id;
	}

	public void setId(AutomovilPK id) {
		this.id = id;
	}

	public String getAnio() {
		return this.anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Empresa> getEmpresas() {
		return this.empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa addEmpresa(Empresa empresa) {
		getEmpresas().add(empresa);
		empresa.setAutomovil(this);

		return empresa;
	}

	public Empresa removeEmpresa(Empresa empresa) {
		getEmpresas().remove(empresa);
		empresa.setAutomovil(null);

		return empresa;
	}

}