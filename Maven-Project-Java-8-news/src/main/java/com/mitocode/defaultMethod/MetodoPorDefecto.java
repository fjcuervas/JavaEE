package com.mitocode.defaultMethod;

public class MetodoPorDefecto implements Persona { 

	@Override
	public void caminar() {
		System.out.println("Método caminar sin implementar");
	}
	
	@Override
	public void hablar() {
		Persona.super.hablar();
	}

	public static void main(String[] args) {
		MetodoPorDefecto app = new MetodoPorDefecto();
		app.hablar();
	}


	
}
