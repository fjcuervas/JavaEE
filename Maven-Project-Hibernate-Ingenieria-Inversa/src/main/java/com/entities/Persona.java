package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERSONA")
	private int idPersona;

	private String apellido1;

	private String apellido2;

	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NAC")
	private Date fechaNac;

	private String nombre;

	@Column(name="SEGUNDO_NOMBRE")
	private String segundoNombre;

	//bi-directional many-to-one association to AficionDeportiva
	@OneToMany(mappedBy="persona")
	private List<AficionDeportiva> aficionDeportivas;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="persona")
	private List<Mascota> mascotas;

	//bi-directional one-to-one association to Parking
	@OneToOne(mappedBy="persona")
	private Parking parking;

	//bi-directional one-to-one association to Direccion
	@OneToOne
	@JoinColumn(name="ID_PERSONA")
	private Direccion direccion;

	public Persona() {
	}

	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public List<AficionDeportiva> getAficionDeportivas() {
		return this.aficionDeportivas;
	}

	public void setAficionDeportivas(List<AficionDeportiva> aficionDeportivas) {
		this.aficionDeportivas = aficionDeportivas;
	}

	public AficionDeportiva addAficionDeportiva(AficionDeportiva aficionDeportiva) {
		getAficionDeportivas().add(aficionDeportiva);
		aficionDeportiva.setPersona(this);

		return aficionDeportiva;
	}

	public AficionDeportiva removeAficionDeportiva(AficionDeportiva aficionDeportiva) {
		getAficionDeportivas().remove(aficionDeportiva);
		aficionDeportiva.setPersona(null);

		return aficionDeportiva;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setPersona(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setPersona(null);

		return mascota;
	}

	public Parking getParking() {
		return this.parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

}