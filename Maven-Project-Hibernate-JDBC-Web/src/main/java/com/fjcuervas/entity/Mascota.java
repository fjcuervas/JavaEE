package com.fjcuervas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MASCOTA")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MASCOTA")
	private int idMascota;
	
	@Column(name = "NOMBRE",length = 100, nullable = false)
	private String nombre;
	
	@Column(name = "TIPO_MASCOTA")
	@Enumerated(EnumType.STRING) //Le indicamos que lo que guarde en base de datos sea un String en lugar de un entero
	private TipoMascota tipo;
	
	//Relación muchos a 1 Bidireccional (La clase Persona tiene una lista de Mascotas y la propiedad mappedBy)
	@ManyToOne
	@JoinColumn(name = "MAS_ID_PERSONA", referencedColumnName = "ID_PERSONA")
	private Persona amo;

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoMascota getTipo() {
		return tipo;
	}

	public void setTipo(TipoMascota tipo) {
		this.tipo = tipo;
	}

	public Persona getAmo() {
		return amo;
	}

	public void setAmo(Persona amo) {
		this.amo = amo;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}

	public Mascota(String nombre, TipoMascota tipo, Persona amo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.amo = amo;
	}

	public Mascota() {
	}
	
}
