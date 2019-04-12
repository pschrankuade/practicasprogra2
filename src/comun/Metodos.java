package comun;

import implementaciones.PilaTF;
import interfaces.ICola;
import interfaces.IConjunto;
import interfaces.IPila;

public abstract class Metodos {
	public static void PasarPila(IPila origen, IPila destino){
		while (!origen.PilaVacia()){
			destino.Apilar(origen.Tope());
			origen.Desapilar();
			
		}
	}
	
	public static int SumarElementosPila(IPila p){
		int suma=0;
		while (!p.PilaVacia()){
			suma = suma + p.Tope();
			p.Desapilar();
		}
		return suma;
	}
	
	public static void PasarCola(ICola origen, ICola destino){
		while (!origen.ColaVacia()){
			destino.Acolar(origen.Primero());
			destino.Desacolar();
		}
	}
	
	public static boolean SonConjuntosIguales(IConjunto primero, IConjunto segundo){
		int elemento;
		boolean sonIguales = true;
		while (!primero.ConjuntoVacio() && !segundo.ConjuntoVacio() && sonIguales){
			elemento = primero.Elegir();
			if (!segundo.Pertenece(elemento)){
				sonIguales = false;
			}
			else{
				primero.Sacar(elemento);
				segundo.Sacar(elemento);
				
			}
		}
		if(primero.ConjuntoVacio() && segundo.ConjuntoVacio())
			return true;
		else
			return false;
	}
	
	public static void MostrarPila(IPila pila){
		if (!pila.PilaVacia()){
			PilaTF copia = new PilaTF();
			copia.InicializarPila();
			Metodos.CopiarPila(pila, copia);
			while (!copia.PilaVacia()){
				System.out.println(copia.Tope());
				copia.Desapilar();
			}
		}
	}
	
	public static void CopiarPila(IPila origen, IPila destino){
		IPila auxiliar = new PilaTF();
		auxiliar.InicializarPila();
		Metodos.PasarPila(origen, auxiliar);
		while(!auxiliar.PilaVacia()){
			int tope = auxiliar.Tope();
			origen.Apilar(tope);
			destino.Apilar(tope);
			auxiliar.Desapilar();
		}
	}
}
