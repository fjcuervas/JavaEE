package com.fjcuervas.test;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.AreaGeografica;
import com.fjcuervas.persistence.GestorPersistencia;

public class InsertarAreaGeografica {
	private static final Logger LOGGER = Logger.getLogger(ConsultarPersona.class);

	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();

		AreaGeografica area1 = new AreaGeografica("ESP","España","PAÍS","Territorio español");
		AreaGeografica area2 = new AreaGeografica("AND","Andalucía","COMUNIDAD","Comunidad andaluza");
		AreaGeografica area3 = new AreaGeografica("CAT","Cataluña","COMUNIDAD","Comunidad catalana");
		AreaGeografica area4 = new AreaGeografica("SEV","Sevilla","PROVINCIA","Provincia de Sevilla");
		AreaGeografica area5 = new AreaGeografica("CAD","Cádiz","PROVINCIA","Provincia de Cádiz");
		AreaGeografica area6 = new AreaGeografica("HUE","Huelva","PROVINCIA","Provincia de Huelva");

		area1.getAreasHijo().add(area2);
		area1.getAreasHijo().add(area3);
		area2.getAreasHijo().add(area4);
		area2.getAreasHijo().add(area5);
		area2.getAreasHijo().add(area6);
		
		area4.setAreaPadre(area2);
		area5.setAreaPadre(area2);
		area6.setAreaPadre(area2);
		
		area2.setAreaPadre(area1);
		area3.setAreaPadre(area1);
		
		gp.insertarAreaGeografica(area1);
		gp.insertarAreaGeografica(area2);
		gp.insertarAreaGeografica(area3);
		gp.insertarAreaGeografica(area4);
		gp.insertarAreaGeografica(area5);
		gp.insertarAreaGeografica(area6);
		
		LOGGER.info(area1);
		LOGGER.info(area2);
		
		gp.closeEntityManager();
	}

}
