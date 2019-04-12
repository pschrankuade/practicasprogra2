package interfaces;

public interface IColaPrioridad {
	void InicializarCola();
	void AcolarPrioridad(int x, int prioridad);
	void Desacolar();
	int Primero();
	boolean ColaVacia();
	int Prioridad();
}
