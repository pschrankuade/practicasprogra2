package interfaces;

public interface ABBTDA {
	
	// siempre que el arbol este inicializado y no este vac ıo
	int Raiz () ;
	// siempre que el arbol este inicializado y no este vac ıo
	ABBTDA HijoIzq() ;
	// siempre que el arbol este inicializado y no este vac ıo
	ABBTDA HijoDer() ;
	// siempre que el arbol este inicializado
	boolean ArbolVacio () ;
	
	void InicializarArbol () ;
	// siempre que el arbol este inicializado
	void AgregarElem( int x);
	// siempre que el arbol este inicializado
	void EliminarElem( int x);
	
}
