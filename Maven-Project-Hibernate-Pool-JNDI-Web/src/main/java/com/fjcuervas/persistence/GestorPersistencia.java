package com.fjcuervas.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import com.fjcuervas.entity.Mascota;
import com.fjcuervas.entity.Parking;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.entity.TipoMascota;

public class GestorPersistencia {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public GestorPersistencia() {
		emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
		em = emf.createEntityManager();
	}

	public Persona consultarPersonaPorId(int idPersona) {
		return em.find(Persona.class, idPersona);
	}
	
	@SuppressWarnings("unchecked")
	public List<Mascota> getMascotasJPQL() {
		String qlString = "select m from Mascota m order by m.amo.nombreCompleto.nombre";
		return em.createQuery(qlString).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mascota> getMascotasPorTipo(TipoMascota tipo) {
		String qlString = "SELECT m FROM Mascota m WHERE m.tipo = :tipoMascota order by m.nombre";
		return em.createQuery(qlString)
				.setParameter("tipoMascota", tipo)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> getPersonasConMascota() {
		String qlString = "SELECT DISTINCT p FROM Persona p JOIN p.mascotas m";
		return em.createQuery(qlString)
				.getResultList();
	}
	
	public List<Persona> getPersonasTipoMascotaJoinCriteria(TipoMascota tipoMascota) {
		//"SELECT DISTINCT p FROM Persona p JOIN p.mascotas m order by m.amo.nombreCompleto.nombre";
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Persona> configConsulta = cb.createQuery(Persona.class);
		
		Root<Persona> raizPersona = configConsulta.from(Persona.class);
		
		Join<Object, Object> joinMascotas = raizPersona.join("mascotas");
		
		configConsulta.select(raizPersona)
					  .distinct(true)
					  .where(cb.equal(joinMascotas.get("tipo"), tipoMascota))
					  .orderBy(cb.asc(raizPersona.get("nombreCompleto").get("nombre")));
					  
					  
		return em.createQuery(configConsulta).getResultList();
	}
	
	public List<Mascota> getMascotasCriteria() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Mascota> configConsulta = cb.createQuery(Mascota.class);
		Root<Mascota> raizMascota = configConsulta.from(Mascota.class);
		configConsulta.select(raizMascota);
		return em.createQuery(configConsulta).getResultList();
	}
	
	public List<Mascota> getMascotasWhereCriteria() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Mascota> configConsulta = cb.createQuery(Mascota.class);
		
		Root<Mascota> raizMascota = configConsulta.from(Mascota.class);
		
		configConsulta.select (raizMascota);
		
		configConsulta.where  (cb.equal(raizMascota.get("tipo"),TipoMascota.PERRO));
		
		configConsulta.orderBy(cb.asc  (raizMascota.get("amo").get("nombreCompleto").get("nombre")));
		
		return em.createQuery(configConsulta).getResultList();
	}
	
	public Persona consultarPersonaPorDNI(String dni) {
		// CriteriaBuilder criteria = em.getCriteriaBuilder();
		// Persona personaRecuperada = em.createQuery(em.)(Persona.class, dni);
		return new Persona();
	}

	public boolean insertarPersona(Persona persona) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(persona);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertarPersonaConParking(Persona persona) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			// Antes de persistir el objeto Persona, debe hacerse la relación de ambos
			// objetos mediante sus métodos setters
			Parking parkingRecuperado = em.merge(persona.getParking());
			parkingRecuperado.setPersonaAsignada(persona);
			persona.setParking(parkingRecuperado);
			em.persist(persona);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modificarPersona(Persona persona) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			// Como JPA necesita tener en caché el objeto persona antes de actualizarlo,
			// tenemos primero que ponerlo en modo Managed
			// para que una vez en caché lo actualice con el que está en base de datos
			// mediante persist().
			// Es decir, primero con merge se lo trae de base de datos, lo combina con
			// nuestro objeto y luego lo actualiza en BD.
			// Si no lo hacemos así y solo usamos el persist(), JPA interpreta se trata de
			// un nuevo registro al no encontrarlo en la caché.
			Persona personaModificada = em.merge(persona);
			em.persist(personaModificada);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean eliminarPersona(Persona persona) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			Persona personaAeliminar = em.merge(persona);
			
			if (persona.getParking() != null) {
				Parking parking = em.merge(persona.getParking());
				parking.setPersonaAsignada(null);
				personaAeliminar.setParking(parking);
			}
			
			em.remove(personaAeliminar);
			
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void closeEntityManager() {
		if (em.isOpen())
			em.close();
	}

	public static GestorPersistencia openEntityManager() {
		if (!em.isOpen()) {
			return new GestorPersistencia();
		}
		return null;
	}
	
	public boolean insertarParking(Parking parking) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(parking);
			tx.commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Parking consultarParkingPorId(int idParking) {
		return em.find(Parking.class, idParking);
	}


}
