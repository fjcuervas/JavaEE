package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area_geografica database table.
 * 
 */
@Entity
@Table(name="area_geografica")
@NamedQuery(name="AreaGeografica.findAll", query="SELECT a FROM AreaGeografica a")
public class AreaGeografica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_AREA")
	private String idArea;

	private String descripcion;

	private String nombre;

	private String tipo;

	//bi-directional many-to-one association to AreaGeografica
	@ManyToOne
	@JoinColumn(name="AG_PADRE")
	private AreaGeografica areaGeografica;

	//bi-directional many-to-one association to AreaGeografica
	@OneToMany(mappedBy="areaGeografica")
	private List<AreaGeografica> areaGeograficas;

	public AreaGeografica() {
	}

	public String getIdArea() {
		return this.idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public AreaGeografica getAreaGeografica() {
		return this.areaGeografica;
	}

	public void setAreaGeografica(AreaGeografica areaGeografica) {
		this.areaGeografica = areaGeografica;
	}

	public List<AreaGeografica> getAreaGeograficas() {
		return this.areaGeograficas;
	}

	public void setAreaGeograficas(List<AreaGeografica> areaGeograficas) {
		this.areaGeograficas = areaGeograficas;
	}

	public AreaGeografica addAreaGeografica(AreaGeografica areaGeografica) {
		getAreaGeograficas().add(areaGeografica);
		areaGeografica.setAreaGeografica(this);

		return areaGeografica;
	}

	public AreaGeografica removeAreaGeografica(AreaGeografica areaGeografica) {
		getAreaGeograficas().remove(areaGeografica);
		areaGeografica.setAreaGeografica(null);

		return areaGeografica;
	}

}