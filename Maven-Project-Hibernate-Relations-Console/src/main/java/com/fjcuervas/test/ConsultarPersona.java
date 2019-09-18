package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;

public class ConsultarPersona {

	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		Persona personaRecuperada = gp.consultarPersonaPorId(5);

		if(personaRecuperada == null) {
			LOGGER.error("No existe ninguna persona con ese ID");
		}else {
			LOGGER.info(personaRecuperada);
		}
		gp.closeEntityManager();

	}
}
