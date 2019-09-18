package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;

public class EliminarPersona {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

		Persona persona = gp.consultarPersonaPorId(2);
		if(gp.eliminarPersona(persona)) {
			LOGGER.info("Persona eliminada con éxtio");
		} else {
			LOGGER.error("Error al eliminar la Persona");
		}
		gp.closeEntityManager();
	}
}
