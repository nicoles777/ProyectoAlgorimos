package TDAListas;

public class DoubleLinkedList implements Lista {

	// Atributos
	// 1) Refencia al principio de la lista
	private Nodo start;
	private int size; // lleva el control de la cantidad de nodos de la lista
	
	public DoubleLinkedList() {
		this.start = null; // Representa el principio y fin de la lista
		this.size = 0;
	} // Fin del constructor

	public int getSize() throws ListaException {
		return this.size;
	} // Fin de getSizr

	public void cancel() {
		this.start = null;
		this.size = 0;
	} // Fin de cancel

	public boolean isEmpty() {
		return this.start == null ? true : false;
	} // Fin de isEmpty

	public void insert(Object element) {
		Nodo aux = this.start; // para moverme por la lista y no perder el inicio
		Nodo newNode = new Nodo(element); // nuevo nodo que estamos almacenando

		if (isEmpty()) { // Caso1: cuando la lista esta vac�a
			this.start = newNode;

		} else {
			while (aux.getNext() != null) {
				aux = aux.getNext();// mueve el aux al siguiente nodo
			} // while
			aux.setNext(newNode);
			// almacenamos el nuevo nodo en la lista
			newNode.setBefore(aux); // hacemos el doble enlace
		} // if-else
		this.size++;
	} // Fin de insert

	public int getPosition(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vac�a");
		} // if

		Nodo aux = this.start; // Para movernos por la lista
		int position = 1; // Indica la posici�n del elemento en la lista

		while (aux != null) {
			if (aux.getElement().equals(element)) {
				return position;
			} // if

			aux = aux.getNext();
			position++;
		} // while

		return -1; // -1 sirve como indicador de que no se encontr� el elemento

	} // Fin de getPosition

	public Object getByPosition(int position) throws ListaException {

		if (this.size < position || position <= 0) {
			throw new ListaException("La posici�n " + position + " no es v�lida");
		}

		Nodo aux = this.start;
		int contador = 1;

		while (contador != position) {
			aux = aux.getNext();
			contador++;
		} // while

		return aux.getElement();

	} // Fin de getByPosition

	public void delete(Object element) {

		if (isEmpty()) {
			throw new ListaException("Lista Vac�a");
		}

		if (this.size == 1 && this.start.getElement().equals(element)) { // Que pasa si s�lo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (this.start.getElement().equals(element)) {
			this.start = this.start.getNext();
			this.start.setBefore(null);
			this.size--;
		} else {
			Nodo aux = this.start;
			
			while (aux.getNext() != null) {
				if (aux.getNext().getElement().equals(element)) {
					aux.setNext(aux.getNext().getNext());
					aux.getNext().setBefore(aux); 
					this.size--;
					break;
				} else {
					aux = aux.getNext();
				}
			} // while
		}

	} // Fin de delete

	public void delete(int position) {
		
		if (this.size < position || position <= 0) {
			throw new ListaException("La posici�n " + position + " no es v�lida");
		} else if (this.size == 1 && position == 1) { // Que pasa si s�lo queda un nodo y es el que desea eliminar
			this.cancel(); // Se anula toda la lista
		} else if (position == 1) {
			this.start = this.start.getNext();
			this.start.setBefore(null);
			this.size--;
		} else {
			Nodo aux = this.start.getNext();
			int contador = 2;

			while (contador != position) {
				aux = aux.getNext();
				contador++;
			} // while
			
			aux.getBefore().setNext(aux.getNext()); 
			aux.getNext().setBefore(aux.getBefore());
			
			this.size--;
		}
		
	}  // Fin de delete

	public boolean exists(Object element) {

		if (isEmpty()) {
			throw new ListaException("DoubleLinkedList is empty");
		} else if (this.start.getElement().equals(element)) {
			return true;
		} else {
			Nodo aux = this.start.getNext();
			while (aux != null) {

				if (aux.getElement().equals(element)) {
					return true;
				} else {
					aux = aux.getNext();
				} // if/else interno

			} // while

			return false;

		} // if/else externo
	} // Fin de exists

	public Object firstInList() {
		return this.start.getElement();
	} // Fin de firstInList

	@Override
	public Object lastInList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {

		if (isEmpty()) {
			return "Lista vac�a";
		} else {

			Nodo aux = this.start;
			String result = "VALORES DE LA LISTA DOBLEMENTE ENLAZADA\n";
			result += "----------------------------------------\n";
			while (aux != null) {
				result += aux.getElement() + "<--->";
				aux = aux.getNext();
			}

			return result;
		} // if / else
		
	} // Fin de toString

	public Nodo getStart() {
		return start;
	}

	public void setStart(Nodo start) {
		this.start = start;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
} // Fin de clase
