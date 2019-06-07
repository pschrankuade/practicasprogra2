package implementaciones;

import interfaces.IPila;

/*** Lista Dinamica
 * 
 * La estrategia entonces ser ́a mantener una cadena de nodos, manteniendo un pun- tero 
 * al tope de la pila, este apuntar ́a al siguiente, y as ́ı sucesivamente. Si la lista 
 * est ́a vac ́ıa, ser ́a un punterno null. Para agregar un nodo, se lo crea, y se agrega 
 * al comienzo de la cadena. Para eliminarlo, simplemente se elimina el primer nodo, dejando 
 * el puntero apuntando al segundo si es que existe.
 * @author mshin
 *
 */
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

