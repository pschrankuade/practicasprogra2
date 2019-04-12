package interfaces;

public interface IConjunto {
	void InicializarConjunto();
	boolean ConjuntoVacio();
	void Agregar(int x);
	int Elegir();
	void Sacar(int x);
	boolean Pertenece(int x);
}
