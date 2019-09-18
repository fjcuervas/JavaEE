package com.mitocode.nashorn;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashApp {

	private ScriptEngineManager mengineManager;
	private ScriptEngine engine;
	private Invocable invocador;
	
	public NashApp() {
		mengineManager = new ScriptEngineManager();
		engine = mengineManager.getEngineByName("nashorn");
		invocador = (Invocable)engine;
	}

	public void llamarFunciones() throws Exception {
		engine.eval(new FileReader("src/main/java/com/mitocode/nashorn/archivo.js"));
		
		String respuesta = (String) invocador.invokeFunction("calcular", "2", "3");		
		System.out.println(respuesta);
		
		double respuesta2 = (double) invocador.invokeFunction("calcular", 2, 3);
		System.out.println(respuesta2);
	}

	public static void main(String[] args) throws Exception {
		NashApp test = new NashApp();
		test.llamarFunciones();
	}
}
