package com.fjcuervas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PERSONA")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONA")
	private int idPersona;
	
	@Column(name = "DNI")
	private String dni;
	
	@Column(name="FECHA_NAC")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String dni, Date fechaNacimiento) {
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona() {
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

}
