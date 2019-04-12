package interfaces;

public interface IDiccionarioSimple {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	int Recuperar(int clave);
	IConjunto Claves();
}
