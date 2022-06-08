package TDAColaEnlazada;

public class Nodo {

	public Nodo next; // puntero al siguiente nodo
	public Object element; // informaci�n
	
	public Nodo(Object element) {
		this.next = null;
		this.element = element;
	} // Fin del constructor
	
} // Fin de clase
