package implementaciones;

import interfaces.IPila;

/*** Tope al Final
 * Implementaci ́on en donde se guardan los datos en un arreglo y adem ́as se tiene 
 * una variable que indica la cantidad de elementos que se tienen guardados en la pila.
 *  Cuando agregamos un nuevo elemento a la pila, el mismo se guarda en la posici ́on 
 *  indicada por la variable que me indica la cantidad de elementos. Cuando se tiene que 
 *  desapilar un elemento de la pila, solo es necesario decrementar en una unidad la 
 *  variable que me indica la cantidad de elementos. Se puede ver el esquema en la figura 3.1.
 *
 */
public class PilaTF implements IPila {
	int[] a;
	int indice;
	@Override
	public void InicializarPila() {
		a = new int[100];
		indice = 0;
	}

	@Override
	public void Apilar(int x) {
		a[indice] = x;
		indice++;

	}

	@Override
	public void Desapilar() {
		indice--;

	}

	@Override
	public boolean PilaVacia() {
		return (indice == 0);
	}

	@Override
	public int Tope() {
		return a[indice-1];
	}

}
