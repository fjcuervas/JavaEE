package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Parking;
import com.fjcuervas.persistence.GestorPersistencia;

public class ConsultarParking {

	private static final Logger LOGGER = Logger.getLogger(ConsultarParking.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		Parking parkingRecuperado = gp.consultarParkingPorId(3);

		if(parkingRecuperado == null) {
			LOGGER.error("No existe ningun parking con ese ID");
		}else {
			LOGGER.info(parkingRecuperado);
		}
		gp.closeEntityManager();

	}
}
