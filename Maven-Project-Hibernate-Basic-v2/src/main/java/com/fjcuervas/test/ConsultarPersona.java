package com.fjcuervas.test;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.NombreCompleto;
import com.fjcuervas.entity.Persona;

public class ConsultarPersona {

	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
		EntityManager em = emf.createEntityManager();

		Persona nuevaPersona = new Persona("55332211T", Date.valueOf(LocalDate.of(1982, 1, 12)),
				new NombreCompleto("Jose Antonio","Martín","Fernandez"));
		
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		em.persist(nuevaPersona);
		transaction.commit();
		
		Persona personaRecuperada = em.find(Persona.class, 1);

		if (personaRecuperada == null) {
			LOGGER.error("No existe ninguna persona con ese ID");
		} else {
			LOGGER.info(personaRecuperada);
		}
		em.close();

	}
}
