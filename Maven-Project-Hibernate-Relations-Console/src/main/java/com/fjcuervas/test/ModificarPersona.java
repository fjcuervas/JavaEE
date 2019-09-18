package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;

public class ModificarPersona {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

//		Persona persona = gp.consultarPersonaPorDNI("53270546Q");
		Persona persona = gp.consultarPersonaPorId(2);
		persona.getMascotas().size();
		persona.setDni("15236523T");
		if(gp.modificarPersona(persona)) {
			LOGGER.info("Persona actualizada con éxtio");
		} else {
			LOGGER.error("Error al actualizar la Persona");
		}
		gp.closeEntityManager();
	}
}
