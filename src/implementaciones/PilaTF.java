package implementaciones;

import interfaces.IPila;

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
