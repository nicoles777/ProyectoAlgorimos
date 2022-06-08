package TDAListas;

public class Nodo {

	// Atributos
	// 1) Informaci�n del nodo
	private Object element;
	
	// 2) Apuntador-Puntero-Referencia
	private Nodo next, before;
	
	public Nodo(Object element) {
		this.element = element;
		this.next = null;
		this.before = null;
	} // Fin del constructor

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Nodo getNext() {
		return next;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Nodo getBefore() {
		return before;
	}

	public void setBefore(Nodo before) {
		this.before = before;
	}
	
} // Fin de clase
