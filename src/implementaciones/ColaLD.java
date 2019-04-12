package implementaciones;

import interfaces.ICola;

public class ColaLD implements ICola {
	Nodo PrimerNodo;
	Nodo UltimoNodo;
	int Count;
	
	@Override
	public void InicializarCola() {
		this.PrimerNodo = null;
		this.UltimoNodo = null;
		this.Count = 0;
	}

	@Override
	public void Acolar(int x) {
		Nodo nuevoNodo = new Nodo(x);
		if(this.PrimerNodo == null && this.UltimoNodo == null){
			this.PrimerNodo = nuevoNodo;
			this.UltimoNodo = nuevoNodo;
		}
		else{
			this.UltimoNodo.NodoSiguiente = nuevoNodo;
			this.UltimoNodo = nuevoNodo;
		}
		this.Count++;
	}

	@Override
	public void Desacolar() {
		if(this.PrimerNodo != this.UltimoNodo)
		{
			this.PrimerNodo = this.PrimerNodo.NodoSiguiente;
			this.Count--;
		}
		else{
			this.PrimerNodo = null;
			this.UltimoNodo = null;
			this.Count = 0;
		}
	}

	@Override
	public boolean ColaVacia() {
		
		return (Count == 0);
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return this.PrimerNodo.Valor;
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



