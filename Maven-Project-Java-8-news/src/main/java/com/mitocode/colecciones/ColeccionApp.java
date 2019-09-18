package com.mitocode.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ColeccionApp {

	private List<Persona> personas;

	public void llenarLista() {
		personas = new ArrayList<>();

		personas.add(new Persona(1,"Antonio"));
		personas.add(new Persona(2,"Pedro"));
		personas.add(new Persona(3,"Javi"));
	}

	public void usarForEach() {
		for(Persona elemento : personas){
			System.out.println(elemento);
		}
		
		//lista.forEach(x -> System.out.println(x));		
		personas.forEach(System.out::println);
		
	}

	
	
	

	public void usarSort() {
		
		//U
		Collections.sort(personas, (o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
		//de forma inversa

		personas.sort(Comparator.comparing(Persona::getNombre).reversed());

		
		
		//personas.sort(Comparator.comparing(Persona::getId));
		
		// Para una lista con datos primitivos como una lista de enteros podríamos hacerlo así
		// colores.sort((x,y)-> y.compareTo(x));
	}

	public static void main(String... mitocode) {
		ColeccionApp app = new ColeccionApp();
		app.llenarLista();		
		app.usarSort();
		app.usarForEach();
		
		
	}

}
