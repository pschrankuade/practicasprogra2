package implementaciones;

import interfaces.ICola;

public class ColaPI implements ICola {
	int[] a;
	int indice;
	@Override
	public void InicializarCola() {
		a = new int[100];
		indice = 0;

	}

	@Override
	public void Acolar(int x) {
		a[indice] = x;
		indice++;

	}

	@Override
	public void Desacolar() {
		for (int i = 0; i< indice -1; i++)
			a[i] = a[i+1];
		indice--;
	}

	@Override
	public boolean ColaVacia() {
		return (indice == 0);
	}

	@Override
	public int Primero() {
		return a[0];
	}

}
