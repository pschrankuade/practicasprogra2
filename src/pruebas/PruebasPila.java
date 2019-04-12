package pruebas;

import comun.Metodos;
import implementaciones.ColaLD;
import implementaciones.PilaLD;
import implementaciones.PilaTF;
import interfaces.ICola;
import interfaces.IPila;

public class PruebasPila {
	public static void main(String[] args) {
		/*
		IPila origen = new PilaLD();
		IPila destino  = new PilaLD();
		origen.InicializarPila();
		destino.InicializarPila();
		origen.Apilar(1);
		origen.Apilar(9);
		origen.Apilar(20);
		
		Metodos.MostrarPila(origen);
		Metodos.PasarPila(origen, destino);
		Metodos.MostrarPila(destino);
		Metodos.CopiarPila(destino, origen);
		Metodos.MostrarPila(origen);
		*/
		ICola unaCola = new ColaLD();
		unaCola.InicializarCola();
		unaCola.Acolar(1);
		unaCola.Acolar(2);
		unaCola.Acolar(3);
		while(!unaCola.ColaVacia()){
			int x = unaCola.Primero();
			unaCola.Desacolar();
			System.out.println(x);
		}
		

	}

}
