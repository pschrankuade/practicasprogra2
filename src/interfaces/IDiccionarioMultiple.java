package interfaces;

public interface IDiccionarioMultiple {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	void EliminarValor(int clave, int valor);
	IConjunto Recuperar(int clave);
	IConjunto Claves();
}
