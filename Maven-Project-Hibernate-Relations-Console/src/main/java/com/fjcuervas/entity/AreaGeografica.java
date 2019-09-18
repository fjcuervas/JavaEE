package com.fjcuervas.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AREA_GEOGRAFICA")
public class AreaGeografica {

	@Id
	@Column(name = "ID_AREA", length = 12)
	private String idArea;
	
	@Column(name = "NOMBRE", length = 30)
	private String nombre;
	
	@Column(name = "TIPO", length = 30)
	private String tipo;
	
	@Column(name = "DESCRIPCION", length = 60)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "AG_PADRE", referencedColumnName = "ID_AREA")
	private AreaGeografica areaPadre;
	
	@OneToMany(mappedBy = "areaPadre")
	private List<AreaGeografica> areasHijo;
	
	public AreaGeografica getAreaPadre() {
		return areaPadre;
	}

	public void setAreaPadre(AreaGeografica areaPadre) {
		this.areaPadre = areaPadre;
	}

	public List<AreaGeografica> getAreasHijo() {
		return areasHijo;
	}

	public void setAreasHijo(List<AreaGeografica> areasHijo) {
		this.areasHijo = areasHijo;
	}

	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public AreaGeografica(String idArea, String nombre, String tipo, String descripcion) {
		this.idArea = idArea;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.areasHijo = new ArrayList<>();
	}


	@Override
	public String toString() {
		return "AreaGeografica [idArea=" + idArea + ", nombre=" + nombre + ", tipo=" + tipo + ", descripcion="
				+ descripcion + ", areaPadre=" + areaPadre + ", areasHijo=" + areasHijo.size() + "]";
	}

	public AreaGeografica() {
		this.areasHijo = new ArrayList<>();
	}
	
}
