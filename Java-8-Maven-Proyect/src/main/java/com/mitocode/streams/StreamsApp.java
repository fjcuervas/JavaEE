package com.mitocode.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamsApp {

	private List<String> colores;
	private List<String> numeros;
	
	public StreamsApp(){
		colores = new ArrayList<>();
		colores.add("Rojo");
		colores.add("Azul");
		colores.add("Verde");
		
		numeros = new ArrayList<>();
		numeros.add("1");
		numeros.add("2");
		numeros.add("3");
	}
	
	public void filtrar(){
		colores.stream().filter(x -> x.startsWith("R")).forEach(System.out::println);
	}
	
	public void ordenar(){
		colores.stream().sorted().forEach(System.out::println);
		colores.stream().sorted((x,y)-> y.compareTo(x)).forEach(System.out::println);
	}
	
	public void transformar(){
		
		//Ejemplo 1: convertimos a mayúscula cada elemento de la lista y la imprimimos
		colores.stream().map(String::toUpperCase).forEach(System.out::println);
		
		//Ejemplo 2 - Forma 1: alteramos los elementos de la lista mediante bucle for
		for(String x : numeros){
			int num = Integer.parseInt(x) + 1;
			System.out.println(num);
		}
		
		//Ejemplo 2 - Forma 12: alteramos los elementos de la lista mediante método map() y expresión Lambda
		numeros.stream().map(x -> Integer.parseInt(x) + 1).forEach(System.out::println);
	}
	
	public void limitar(){
		colores.stream().limit(2).forEach(System.out::println);
	}
	
	public void contar(){
		long x = colores.stream().count();
		System.out.println(x);
	}
		
	public static void main(String[] args) {
		StreamsApp app = new StreamsApp();
		//app.filtrar();
		//app.ordenar();
		app.transformar();
		//app.limitar();
		//app.contar();
		
	}
}
