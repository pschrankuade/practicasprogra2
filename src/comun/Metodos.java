
package comun;

import implementaciones.ConjuntoLD;
import implementaciones.DicSimpleA;
import implementaciones.PilaTF;
import interfaces.ABBTDA;
import interfaces.ICola;
import interfaces.IConjunto;
import interfaces.IDiccionarioSimple;
import interfaces.IPila;

public abstract class Metodos {

	/**
	 * a) Pasar una Pila a otra (dejándola en orden inverso)
	 */
	public static void PasarPila(IPila origen, IPila destino) {
		while (!origen.PilaVacia()) {
			destino.Apilar(origen.Tope());
			origen.Desapilar();
		}
	}

	/**
	 * b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
	 */
	public static void CopiarPila(IPila origen, IPila destino) {
		IPila auxiliar = new PilaTF();
		auxiliar.InicializarPila();
		Metodos.PasarPila(origen, auxiliar);
		while (!auxiliar.PilaVacia()) {
			int tope = auxiliar.Tope();
			origen.Apilar(tope);
			destino.Apilar(tope);
			auxiliar.Desapilar();
		}
	}

	/**
	 * c) Invertir el contenido de una Pila.
	 */
	public static IPila InvertirPila(IPila origen) {
		IPila auxiliar = new PilaTF();
		while (!origen.PilaVacia()) {
			auxiliar.Apilar(origen.Tope());
			origen.Desapilar();
		}
		return auxiliar;
	}

	/**
	 * d) Contar los elementos de una Pila
	 */
	public static int contarPila(IPila pila) {
		return pila.Tope();
	}

	/**
	 * e) Sumar los elementos de una Pila
	 */
	public static int SumarElementosPila(IPila p) {
		int suma = 0;
		while (!p.PilaVacia()) {
			suma = suma + p.Tope();
			p.Desapilar();
		}
		return suma;
	}

	/**
	 * f) Calcular el promedio de los elementos de una Pila
	 */
	public static float CalcularPromedioPila(IPila p) {
		float suma = 0;
		float cantidad = p.Tope();
		float promedio = 0;

		while (!p.PilaVacia()) {
			suma = suma + p.Tope();
			p.Desapilar();
		}

		promedio = suma / cantidad;
		return promedio;
	}

	public static void PasarCola(ICola origen, ICola destino) {
		while (!origen.ColaVacia()) {
			destino.Acolar(origen.Primero());
			destino.Desacolar();
		}
	}

	public static boolean SonConjuntosIguales(IConjunto primero, IConjunto segundo) {
		int elemento;
		boolean sonIguales = true;
		while (!primero.ConjuntoVacio() && !segundo.ConjuntoVacio() && sonIguales) {
			elemento = primero.Elegir();
			if (!segundo.Pertenece(elemento)) {
				sonIguales = false;
			} else {
				primero.Sacar(elemento);
				segundo.Sacar(elemento);

			}
		}
		if (primero.ConjuntoVacio() && segundo.ConjuntoVacio())
			return true;
		else
			return false;
	}

	public static void MostrarPila(IPila pila) {
		if (!pila.PilaVacia()) {
			PilaTF copia = new PilaTF();
			copia.InicializarPila();
			Metodos.CopiarPila(pila, copia);
			while (!copia.PilaVacia()) {
				System.out.println(copia.Tope());
				copia.Desapilar();
			}
		}
	}

	public int Contar(ABBTDA a) {
		if (a.ArbolVacio()) {
			return 0;
		} else {
			return (1 + Contar(a.HijoIzq()) + Contar(a.HijoDer()));
		}
	}

	public int calcularProfundidad(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return 0;
		} else if (t.Raiz() == x) {
			return 0;
		} else if (t.Raiz() > x) {
			return (1 + this.calcularProfundidad(t.HijoIzq(), x));
		} else {
			return (1 + this.calcularProfundidad(t.HijoDer(), x));
		}
	}

	public boolean existeElementoEnABB(ABBTDA t, int x) {
		if (t.ArbolVacio()) {
			return false;
		} else if (t.Raiz() == x) {
			return true;
		} else if (t.Raiz() > x) {
			return this.existeElementoEnABB(t.HijoIzq(), x);
		} else {
			return this.existeElementoEnABB(t.HijoDer(), x);
		}
	}

	public IConjunto nodosPares(ABBTDA a) {
		IConjunto r = new ConjuntoLD();
		r.InicializarConjunto();
		if (!a.ArbolVacio()) {
			if (a.Raiz() % 2 == 0) {
				r.Agregar(a.Raiz());
			}
			IConjunto rI = nodosPares(a.HijoIzq());
			IConjunto rD = nodosPares(a.HijoDer());
			while (!rI.ConjuntoVacio()) {
				int x = rI.Elegir();
				r.Agregar(x);
				rI.Sacar(x);
			}
			while (!rD.ConjuntoVacio()) {
				int x = rD.Elegir();
				r.Agregar(x);
				rD.Sacar(x);
			}
		}
		return r;
	}
	
	/*
	 * a) Dado un elemento, determinar si está o no en un ABB. 
	 * b) Dado un elemento, determinar si es una hoja de un ABB. 
	 * c) Dado un elemento, calcular su profundidad en el ABB. 
	 * d) Obtener el valor del menor elemento de un ABB. 
	 * e) Calcular la cantidad de elementos que contiene un ABB. 
	 * f) Calcular la suma de los elementos que contiene un ABB. 
	 * g) Calcular el cantidad de hojas de un ABB h) Calcular la altura de un ABB. 
	 * i) Comprobar si dos ABBs tienen la misma forma. j) Comprobar si dos ABBs son iguales. 
	 * k) Contar la cantidad de elementos que están en un cierto nivel N. 
	 * l) Mostrar por pantalla todos los elementos que contiene un ABB 
	 * 		i.In-orden 
	 * 		ii.Pre-orden 
	 * 		iii.Post-orden 
	 * m) Dado un valor k, arme un conjunto con todos los elementos del ABB que son mayores que k.
	 * n) Dado un elemento de valor v (que está presente en el ABB), 
	 * obtener el elemento del árbol que es inmediatamente anterior (en valor). 
	 * */
	
	public IDiccionarioSimple obtenerAlturas(ABBTDA arbol ) {
		
		IDiccionarioSimple diccionarioSimple = new DicSimpleA();
		int n = Contar(arbol);
		
		if(n != 1) {
			obtenerAlturas(arbol.HijoIzq());
			
			obtenerAlturas(arbol.HijoDer());
			
			//sumar diccionarios
			
		} else {
			diccionarioSimple.Agregar(arbol.Raiz(), Contar(arbol.HijoIzq()) - Contar(arbol.HijoDer()));
		}
		
		return diccionarioSimple;
	}
	
	
}
