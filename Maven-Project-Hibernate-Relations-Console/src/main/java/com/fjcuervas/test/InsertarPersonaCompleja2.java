package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarPersonaCompleja2 {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

		Persona persona = Util.crearPersona2();
		persona = Util.insertarParking2(persona);
		persona = Util.insertarMascotas2(persona);
		
		if(gp.insertarPersona(persona)) {
			LOGGER.info("Persona insertada con éxtio");
		} else {
			LOGGER.error("Error al insertar la Persona");
		}
		gp.closeEntityManager();
	}

}
