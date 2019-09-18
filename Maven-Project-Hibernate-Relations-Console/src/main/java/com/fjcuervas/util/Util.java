package com.fjcuervas.util;

import java.sql.Date;
import java.time.LocalDate;

import com.fjcuervas.entity.AreaGeografica;
import com.fjcuervas.entity.Automovil;
import com.fjcuervas.entity.AutomovilPK;
import com.fjcuervas.entity.Direccion;
import com.fjcuervas.entity.Empresa;
import com.fjcuervas.entity.Mascota;
import com.fjcuervas.entity.NombreCompleto;
import com.fjcuervas.entity.Parking;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.entity.TipoMascota;

public class Util {
	public static Persona crearPersonaSimple() {
		NombreCompleto nombreCompleto = new NombreCompleto("Esperanza", "", "Cuervas", "Muñoz");
		return new Persona("34343434Q", Date.valueOf(LocalDate.of(1980, 7, 19)), nombreCompleto);
	}
	
	public static Persona crearPersona() {
		Direccion direccion = crearDireccion();
		NombreCompleto nombreCompleto = crearNombreCompleto();
		return new Persona("93270546Q", Date.valueOf(LocalDate.of(1982, 1, 15)), nombreCompleto, direccion);
	}
	
	public static Persona crearPersona2() {
		Direccion direccion = crearDireccion2();
		NombreCompleto nombreCompleto = crearNombreCompleto2();
		return new Persona("25465455Q", Date.valueOf(LocalDate.of(1975, 3, 20)), nombreCompleto, direccion);
	}
	
	public static Automovil crearAutomovil() {
		return new Automovil(new AutomovilPK("SE-5341","ESP"),"Opel","Corsa","2017","Rojo","14000");
	}

	public static Persona insertarParking(Persona persona) {
		persona.setParking(new Parking("Castelao", "S-1", persona));
		return persona;
	}
	
	public static Persona insertarParking2(Persona persona) {
		persona.setParking(new Parking("Alavera", "S-2", persona));
		return persona;
	}

	public static Parking crearParking() {
		return new Parking("Castelao", "S-1");
	}

	public static NombreCompleto crearNombreCompleto() {
		return new NombreCompleto("Francisco", "Javier", "Cuervas", "Muñoz");
	}
	
	public static NombreCompleto crearNombreCompleto2() {
		return new NombreCompleto("Julio", "Alberto", "Moo", "Fernandez");
	}

	public static Direccion crearDireccion() {
		return new Direccion("El Bus", 41927);
	}
	
	public static Direccion crearDireccion2() {
		return new Direccion("Alero de Sevilla", 41927);
	}

	public static Persona insertarMascotas(Persona persona) {
		persona.getMascotas().add(new Mascota("Yaki", TipoMascota.PERRO, persona));
		persona.getMascotas().add(new Mascota("Lulu", TipoMascota.GATO, persona));
		persona.getMascotas().add(new Mascota("Yasmin", TipoMascota.CONEJO, persona));
		return persona;
	}
	
	public static Persona insertarMascotas2(Persona persona) {
		persona.getMascotas().add(new Mascota("Nemo", TipoMascota.PERRO, persona));
		persona.getMascotas().add(new Mascota("Sira", TipoMascota.PERRO, persona));
		return persona;
	}

	private Util() {

	}
	
	public static Automovil insertarEmpresa(Automovil automovil) {
		automovil.getPatrocinadores().add(new Empresa("A1234567", "Red Bull", "Bebida energética S.A.",automovil));
		automovil.getPatrocinadores().add(new Empresa("B3453241", "Telefónica", "Red de telefonía S.A.",automovil));
		automovil.getPatrocinadores().add(new Empresa("C9367933", "Gas Natural", "Red suministro energético S.A.",automovil));
		return automovil;
	}
}
