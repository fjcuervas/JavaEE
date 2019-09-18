package com.fjcuervas.test;

import java.util.List;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Mascota;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.entity.TipoMascota;
import com.fjcuervas.persistence.GestorPersistencia;

public class consultarPersonasTipoMascotaCriteria {

	private static final Logger LOGGER = Logger.getLogger(consultarPersonasTipoMascotaCriteria.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		List<Persona> personas = gp.getPersonasTipoMascotaJoinCriteria(TipoMascota.GATO);

		if(personas.isEmpty()) {
			LOGGER.error("No existen personas con ese tipo de mascota");
		}else {
			LOGGER.info("Listado de personas con mascota tipo GATO:\n");
			for (Persona persona : personas) {
				System.out.println(persona.getNombreCompleto());
			}
		}
		
		gp.closeEntityManager();

	}
}
