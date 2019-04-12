package implementaciones;

import interfaces.IConjunto;
import interfaces.IDiccionarioSimple;

public class DicSimpleA implements IDiccionarioSimple {
	class Elemento {
		int clave;
		int valor;
	}
	Elemento[] elementos;
	int cant;
	
	@Override
	public void InicializarDiccionario() {
		cant = 0;
		elementos =new Elemento[100];

	}

	@Override
	public void Agregar(int clave, int valor) {
		int pos = Clave2Indice(clave);
		if(pos==1){
			pos=cant;
			elementos[pos] = new Elemento();
			elementos[pos].clave = clave;
			cant++;
		}
		elementos[pos].valor = valor;
	}

	private int Clave2Indice(int clave){
		int i = cant-1;
		while(i>=0 && elementos[i].clave!=clave)
			i--;
		return i;
	}
	
	@Override
	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if(pos!=-1){
			elementos[pos] = elementos[cant-1];
			cant--;
		}
	}

	@Override
	public int Recuperar(int clave) {
		int pos = Clave2Indice(clave);
		return elementos[pos].valor;
	}

	@Override
	public IConjunto Claves() {
		IConjunto conjunto = new ConjuntoTA();
		conjunto.InicializarConjunto();
		for(int i=0; i<cant; i++){
			conjunto.Agregar(elementos[i].clave);
		}
		return conjunto;
	}

}
