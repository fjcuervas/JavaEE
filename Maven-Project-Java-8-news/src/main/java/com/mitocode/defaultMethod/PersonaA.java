package com.mitocode.defaultMethod;

public interface PersonaA {

	public void caminar();
	
	default public void hablar(){
		System.out.println("Método hablar desde la PersonaA");
	}
}
