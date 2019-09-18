package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Empresa;
import com.fjcuervas.entity.Parking;
import com.fjcuervas.entity.Persona;
import com.fjcuervas.persistence.GestorPersistencia;
import com.fjcuervas.util.Util;

public class InsertarEmpresa {
	private static final Logger LOGGER = Logger.getLogger(InsertarEmpresa.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		
		gp.insertarEmpresa(new Empresa("A1234567", "Red Bull", "Bebida energética S.A.",null));
		gp.insertarEmpresa(new Empresa("B3453241", "Telefónica", "Red de telefonía S.A.",null));
		gp.insertarEmpresa(new Empresa("C9367933", "Gas Natural", "Red suministro energético S.A.",null));
		
		LOGGER.info("Empresas insertadas con éxtio");
		
		gp.closeEntityManager();
	}

}
