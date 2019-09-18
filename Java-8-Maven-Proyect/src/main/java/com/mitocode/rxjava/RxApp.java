package com.mitocode.rxjava;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

public class RxApp {

	private List<Integer> colores1;
	private List<Integer> colores2;

	public RxApp() {
		colores1 = new ArrayList<>();
		colores2 = new ArrayList<>();
		this.llenarcoloress();
	}

	public void llenarcoloress() {
		for (int i = 0; i < 10000; i++) {
			colores1.add(i);
			colores2.add(i);
		}
	}

	public void buscar() {
		Observable<Integer> obs1 = Observable.from(colores1);
		Observable<Integer> obs2 = Observable.from(colores2);
		
		// Forma 1: mediante implemntación del método call()
		Observable.merge(obs1, obs2).subscribe(new Action1<Integer>(){

			@Override
			public void call(Integer numero) {
				if(numero == 1){
					System.out.println(numero);
				}
			}			
		});
		
		// Forma 2: mediante expresiones Lambda
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(System.out::println);
		
		Observable.merge(obs1, obs2).filter(x->x==1).subscribe(x -> {
			if(x == 1){
				System.out.println(x);
			}
		});
	}

	public static void main(String[] args) {
		
		 List<String> colores = new ArrayList<>();
		 
		 colores.add("Rojo");		 
		 colores.add("Verde"); 
		 colores.add("Azul");
		  
		 Observable<String> obs = Observable.from(colores); 
		 
		 obs.subscribe(new Action1<String>(){
			 @Override public void call(String elemento) {
				 System.out.println(elemento); 
			 }		  
		  });
		 
		
		//RxApp app = new RxApp();
		//app.buscar();

	}
}
