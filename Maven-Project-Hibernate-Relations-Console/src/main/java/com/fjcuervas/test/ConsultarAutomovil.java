package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.Automovil;
import com.fjcuervas.entity.Empresa;
import com.fjcuervas.persistence.GestorPersistencia;

public class ConsultarAutomovil {

	private static final Logger LOGGER = Logger.getLogger(ConsultarAutomovil.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		Automovil automovilRecuperado = gp.consultarAutomvilPorId("SE-5341","ESP");
		
		if(automovilRecuperado == null) {
			LOGGER.error("No existe ningún vehículo con esa matrícula");
		}else {
			LOGGER.info(automovilRecuperado);
			for (Empresa empresa : automovilRecuperado.getPatrocinadores()) {
				
				System.out.println(empresa.getNombreComercial());
				
			}
		}
		gp.closeEntityManager();

	}
}
