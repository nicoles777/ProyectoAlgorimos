package TDAListas;

public interface Lista {

	// Devuelve cantidad de nodos de la lista
	public int getSize() throws ListaException;
	
	// Eliminar, destruir, anular, resetear
	public void cancel();
	
	// true or false
	// true si la lista est� vac�a
	public boolean isEmpty();
	
	// Agregar un nuevo nodo a la lista
	public void insert(Object element);
	
	// Devuelve la posici�n de un elemento de la lista
	public int getPosition(Object element);
	
	public Object getByPosition(int position) throws ListaException;
	
	// Eliminar, borrar un elemento de la lista
	public void delete(Object element);
	public void delete(int position);
	
	// Devuelve true si existe el elemento en la lista
	public boolean exists(Object element);
	
	// Devuelve el primer elemento de la lista
	// return inicio.element;
	public Object firstInList();
	
	// Devuelve el �ltimo elemento de la lista
	public Object lastInList();
	
	
} // Fin de interface
