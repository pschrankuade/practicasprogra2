package implementaciones;

import interfaces.ICola;

public class ColaPU implements ICola {
	int[] a;
	int indice;
	@Override
	public void InicializarCola() {
		a = new int[100];
		indice = 0;
	}

	@Override
	public void Acolar(int x) {
		for (int i = indice -1; i>=0; i--)
			a[i+1] = a[i];
		a[0] = x;
		indice++;

	}

	@Override
	public void Desacolar() {
		indice--;

	}

	@Override
	public boolean ColaVacia() {
		return (indice ==0);
	}

	@Override
	public int Primero() {
		return a[indice-1];
	}

}
