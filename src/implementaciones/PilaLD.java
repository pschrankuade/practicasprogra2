package implementaciones;

import interfaces.IPila;

public class PilaLD implements IPila {
	int Count;
	Nodo UltimoNodo;
	
	@Override
	public void InicializarPila(){
		Count = 0;
		UltimoNodo = null;
	}
	
	@Override
	public void Apilar(int valor){
		Nodo nuevoNodo = new Nodo(valor);
		if(UltimoNodo == null)
			UltimoNodo = nuevoNodo;
		else{
			nuevoNodo.NodoSiguiente = UltimoNodo;
			UltimoNodo = nuevoNodo;
		}
		Count++;
	}
	
	@Override
	public void Desapilar() {
		this.UltimoNodo = this.UltimoNodo.NodoSiguiente;
		Count--;
	}

	@Override
	public boolean PilaVacia() {
		return (UltimoNodo==null);
	}

	@Override
	public int Tope() {
		return UltimoNodo.Valor;
	}
	class Nodo {
		Nodo NodoSiguiente;
		int Valor;
		Nodo(int valor){
			this.Valor = valor;
			this.NodoSiguiente = null;
		}
	}

}

