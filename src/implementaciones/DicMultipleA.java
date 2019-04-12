package implementaciones;

import interfaces.IConjunto;
import interfaces.IDiccionarioMultiple;

public class DicMultipleA implements IDiccionarioMultiple {
	class Elemento {
		int clave;
		int[] valores;
		int cantValores;
	}
	
	Elemento[] elementos;
	int cantClaves;
	
	@Override
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;

	}

	@Override
	public void Agregar(int clave, int valor) {
		int posicionClave = Clave2Indice(clave);
		if(posicionClave == -1){
			posicionClave = cantClaves;
			elementos[posicionClave] = new Elemento();
			elementos[posicionClave].clave = clave;
			elementos[posicionClave].cantValores = 0;
			elementos[posicionClave].valores = new int[100];
			cantClaves++;
		}

	}
	
	private int Clave2Indice(int clave){
		int i = cantClaves -1;
		while(i>=0 && elementos[i].clave!=clave)
			i--;
		return i;
	}
	
	private int Valor2Indice(Elemento elemento, int valor){
		int i = elemento.cantValores-1;
		while(i>=0 && elemento.valores[i]!=valor)
			i--;
		return i;
	}

	@Override
	public void Eliminar(int clave) {
		int posicion = Clave2Indice(clave);
		if(posicion!=1) {
			elementos[posicion] = elementos[cantClaves-1];
			cantClaves--;
		}

	}

	@Override
	public void EliminarValor(int clave, int valor) {
		int posicionClave = Clave2Indice(clave);
		if(posicionClave!=1){
			Elemento elemento = elementos[posicionClave];
			int posicionValor = Valor2Indice(elemento, valor);
			if(posicionValor!=-1){
				elemento.valores[posicionValor] = elemento.valores[elemento.cantValores -1];
				elemento.cantValores--;
				if (elemento.cantValores == 0)
					Eliminar(clave);
			}
		}

	}

	@Override
	public IConjunto Recuperar(int clave) {
		IConjunto conjunto = new ConjuntoTA();
		conjunto.InicializarConjunto();
		int posicion = Clave2Indice(clave);
		if(posicion!=-1){
			Elemento elemento = elementos[posicion];
			for(int i=0; i<elemento.cantValores;i++){
				conjunto.Agregar(elemento.valores[i]);
			}
		}
		return conjunto;
	}

	@Override
	public IConjunto Claves() {
		IConjunto conjunto = new ConjuntoTA();
		conjunto.InicializarConjunto();
		for(int i=0; i<cantClaves; i++){
			conjunto.Agregar(elementos[i].clave);
		}
		return conjunto;
	}

}
