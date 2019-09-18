package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Parking;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarPersona {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		
		if(gp.insertarPersona(Util.crearPersonaSimple())) {
			LOGGER.info("Persona insertada con éxtio");
		} else {
			LOGGER.error("Error al insertar la Persona");
		}
		gp.closeEntityManager();
	}

}
