package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarPersonaCompleja {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

		Persona persona = Util.crearPersona();
		persona = Util.insertarParking(persona);
		persona = Util.insertarMascotas(persona);
		
		if(gp.insertarPersona(persona)) {
			LOGGER.info("Persona insertada con éxtio");
		} else {
			LOGGER.error("Error al insertar la Persona");
		}
		gp.closeEntityManager();
	}

}
