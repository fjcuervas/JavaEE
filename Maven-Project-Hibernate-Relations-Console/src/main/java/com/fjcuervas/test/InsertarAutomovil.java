package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Automovil;
import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarAutomovil {
	private static final Logger LOGGER = Logger.getLogger(InsertarAutomovil.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		
		Automovil automovil = Util.crearAutomovil();
		
		automovil = Util.insertarEmpresa(automovil);
		
		if(gp.insertarAutomovil(automovil)) {
			LOGGER.info("Automovil insertado con éxtio");
			LOGGER.info(automovil);
		} else {
			LOGGER.error("Error al insertar el Automovil");
		}
		gp.closeEntityManager();
	}

}
