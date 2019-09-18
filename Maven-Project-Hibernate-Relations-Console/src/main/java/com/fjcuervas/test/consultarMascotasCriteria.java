package com.fjcuervas.test;

import java.util.List;

import org.jboss.logging.Logger;

import com.fjcuervas.entity.AreaGeografica;
import com.fjcuervas.entity.Mascota;
import com.fjcuervas.entity.TipoMascota;
import com.fjcuervas.persistence.GestorPersistencia;

public class consultarMascotasCriteria {

	private static final Logger LOGGER = Logger.getLogger(consultarMascotasCriteria.class);
	
	public static void main(String[] args) {

		GestorPersistencia gp = new GestorPersistencia();
		List<Mascota> mascotas = gp.getMascotasCriteria();

		if(mascotas.isEmpty()) {
			LOGGER.error("No existen mascotas");
		}else {
			LOGGER.info("Listado de mascotas:\n");
			for (Mascota mascota : mascotas) {
				System.out.println(mascota.getNombre() + " cuyo dueño es " + mascota.getAmo().getNombreCompleto().getNombre() + 
						" " + mascota.getAmo().getNombreCompleto().getSegundoNombre());
			}
		}
		
		gp.closeEntityManager();

	}
}
