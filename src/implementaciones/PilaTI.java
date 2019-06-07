package implementaciones;

import interfaces.IPila;

/** Tope al Inicio
 * 
 *  Otra variante de implementaci ́on es utilizar tambi ́en un arreglo para almacenar los datos y 
 *  tener una variable que indica la cantidad de elementos que se tienen guardados en la pila,
 *  pero cuando agregamos un nuevo elemento a la pila, en vez de hacerlo en la posici ́on 
 *  sen ̃alada por la variable que me indica la cantidad de elementos, se guarda en la primera 
 *  posici ́on (es decir, la posici ́on 0 del arreglo). Esto tiene como desventaja que cuando se 
 *  agrega un elemento se debe hacer un corrimiento del resto de los elementos hacia la derecha, 
 *  y cuando se desapila un elemento de la pila nuevamente se tiene que hacer un corrimiento de 
 *  elementos pero esta vez hacia la izquierda.
 *  Se puede observar que la variante entre esta implementaci ́on y la anterior no esta dada en la
 *  estructura utilizada para guardar los elementos sino en el criterio utilizado para almacenar esa informaci ́on.
*/
public class PilaTI implements IPila {
	int[] a;
	int indice;
	@Override
	public void InicializarPila() {
		a = new int[100];
		indice = 0;

	}

	@Override
	public void Apilar(int x) {
		for (int i = indice -1;i >= 0; i--){
			a[i+1] = a[i];
		
		}
		a[0] = x;
		indice++;

	}

	@Override
	public void Desapilar() {
		for (int i = 0; i<indice; i++){
			a[i] = a[i+1];
		}
		indice--;
	}

	@Override
	public boolean PilaVacia() {
		return (indice == 0);
	}

	@Override
	public int Tope() {
		return a[0];
	}

}
