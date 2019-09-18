package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarParking {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

		if(gp.insertarParking(Util.crearParking())) {
			LOGGER.info("Parking insertado con éxtio");
		} else {
			LOGGER.error("Error al insertar el Parking");
		}
		gp.closeEntityManager();
	}

}
