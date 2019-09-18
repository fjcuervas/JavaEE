package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.AreaGeografica;
import com.fjcuervas.persistence.GestorPersistencia;

public class ConsultarAreaGeografica {

	private static final Logger LOGGER = Logger.getLogger(ConsultarAreaGeografica.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		AreaGeografica areaGeografica = gp.consultarAreaGeograficaPorId("ESP");

		if(areaGeografica == null) {
			LOGGER.error("No existe ningún areaGeografica con ese ID");
		}else {
			LOGGER.info(areaGeografica);
			
			System.out.println(areaGeografica.getNombre() + " contiene las siguientes comunidades autónomas:");
			
			for (AreaGeografica areaHija : areaGeografica.getAreasHijo()) {
			
				if(!areaHija.getAreasHijo().isEmpty()) {
					System.out.println("\n" + areaHija.getNombre() + " que contiene las siguientes provincias: \n");
				}else {
					System.out.println("\n" + areaHija.getNombre() + " no contiene provincias actualmente.\n");
				}
				
				for (AreaGeografica areaHija2 : areaHija.getAreasHijo()) {
					System.out.println("\t-" + areaHija2.getNombre());
				}
				
			}
		}
		gp.closeEntityManager();

	}
}
