package com.mitocode.anotaciones;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AnotacionesRepeticion {

	@Retention(RetentionPolicy.RUNTIME)
	public @interface Lenguajes {
		Lenguaje[] value() default {};
	}
	
	@Repeatable(value = Lenguajes.class)
	public @interface Lenguaje{
		String value();
		String nombreUsuario() default "Antonio"; 
	}
	
	// Forma 1: anterior a Java 8
	//@Lenguajes({
	//	@Lenguaje("Java"),
	//	@Lenguaje("Python")
	//})
	
	// Forma 2: a partir de Java 8
	@Lenguaje("Java")
	@Lenguaje("Python")
	public interface LenguajeProgramacion{
		
	}

	public static void main(String[] args) {
		
		//Obtenemos un array de anotaciones de tipo Lenguaje que hemos definido de repetición con @Repetable
		Lenguaje[] lenguajeArray = LenguajeProgramacion.class.getAnnotationsByType(Lenguaje.class);
		
		System.out.println("Existen " + lenguajeArray.length + " anotaciones en Lenguaje[]");
		
		//Recorremos cada una de las anotaciones de la interfaz Lenguajes
		Lenguajes len = LenguajeProgramacion.class.getAnnotation(Lenguajes.class);
		
		for(Lenguaje elemento : len.value()){
			System.out.println(elemento.value());
		}
	}
}
