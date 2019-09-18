package com.fjcuervas.test;

import java.util.List;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Mascota;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;

public class consultarPersonaJOINMascotaJPQL {

	private static final Logger LOGGER = Logger.getLogger(consultarPersonaJOINMascotaJPQL.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		List<Persona> personas = gp.getPersonasConMascota();

		if(personas.isEmpty()) {
			LOGGER.error("No existen personas con mascota");
		}else {
			LOGGER.info("Listado de personas con mascota:\n");
			for (Persona persona : personas) {
				System.out.println(persona.getNombreCompleto().getNombre());
			}
		}
		
		gp.closeEntityManager();

	}
}
