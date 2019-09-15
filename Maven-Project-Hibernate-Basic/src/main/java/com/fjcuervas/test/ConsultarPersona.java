package com.fjcuervas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Persona;

public class ConsultarPersona {

	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
		EntityManager em = emf.createEntityManager();

		Persona personaRecuperada = em.find(Persona.class, 1);

		if (personaRecuperada == null) {
			LOGGER.error("No existe ninguna persona con ese ID");
		} else {
			LOGGER.info(personaRecuperada);
		}
		em.close();

	}
}
