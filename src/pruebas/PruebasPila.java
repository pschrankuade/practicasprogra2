package pruebas;

import comun.Metodos;
import implementaciones.PilaTF;
import interfaces.IPila;

public class PruebasPila {
	public static void main(String[] args) {
		IPila origen = new PilaTF();
		IPila destino  = new PilaTF();
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

	}

}
