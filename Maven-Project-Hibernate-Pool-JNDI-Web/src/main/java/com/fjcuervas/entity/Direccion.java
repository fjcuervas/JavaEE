package com.fjcuervas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@TableGenerator(name = "clavesDireccion", table = "CLAVES_AUTOGENERADAS", pkColumnName = "ID_TABLA",
				pkColumnValue = "EMPLEADO", initialValue = 10000, valueColumnName = "NEXT_VALUE", allocationSize = 5)
@Entity
@Table(name = "DIRECCION")
public class Direccion {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "clavesDireccion")
	@Column(name = "ID_DIRECCION")
	private int idDireccion;
	
	@Column(name = "CALLE",length = 200)
	private String calle;
	
	@Column(name = "CODIGO_POSTAL")
	private int cp;
	
	public int getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public Direccion() {
	}
	public Direccion(String calle, int cp) {
		this.calle = calle;
		this.cp = cp;
	}
	@Override
	public String toString() {
		return "Direccion [idDireccion=" + idDireccion + ", calle=" + calle + ", cp=" + cp + "]";
	}
	
	
	
}
