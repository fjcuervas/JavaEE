package com.fjcuervas.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	
	@Embedded
	private NombreCompleto nombreCompleto;
	
	//Relación 1 a 1 Unidireccional (La clase Direccion no tiene ningún atributo Persona)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_DIRECCION")
	private Direccion direccion;

	//Relación 1 a 1 Bidireccional
	@OneToOne(mappedBy = "personaAsignada",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Parking parking;
	
	@Transient //Con esta anotación el atributo no persiste
	private int edad;
	
	//Relación 1 a muchos Bidireccional (La clase Mascota tiene la anotación JoinColumn)
	@OneToMany(mappedBy = "amo",cascade = {CascadeType.ALL})
	private Set<Mascota> mascotas;
	
	public Persona() {
		this.mascotas = new HashSet<Mascota>();
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

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

	public NombreCompleto getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(NombreCompleto nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
				+ ", nombreCompleto=" + nombreCompleto + ", direccion=" + direccion + ", parking=" + parking + ", edad="
				+ edad + ", mascotas=" + mascotas + "]";
	}

	public Persona(String dni, Date fechaNacimiento, NombreCompleto nombreCompleto, Direccion direccion) {
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreCompleto = nombreCompleto;
		this.direccion = direccion;
		this.mascotas = new HashSet<Mascota>();
	}

	public Persona(String dni, Date fechaNacimiento, NombreCompleto nombreCompleto) {
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreCompleto = nombreCompleto;
	}
}
