package com.mitocode.defaultMethod;

public interface PersonaB {

	public void caminar();
	
	default public void hablar(){
		System.out.println("Método hablar desde la PersonaB");
	}
}
