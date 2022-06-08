package TDAPilaEnlazada;

import java.io.Serializable;

import TDAColaEnlazada.Cola;

public class PilaEnlazada implements Pila, Serializable{

	private static final long serialVersionUID = 1L;
	private Nodo top;//Representa el inicio de la lista
	private int cont;//Nos permite saber el num de elementos que tiene la pila
	
	
	public PilaEnlazada() {
		this.top=null;//inicializamos la pila
		this.cont=0;//Aun no hay valores en la pila
		
	}//Consturctor()


	@Override
	public void cancel() {
		this.top=null;
		this.cont=0;
	}//cancel()


	@Override
	public int getSize() {
		return this.cont;
	}//getSize()


	@Override
	public boolean isEmpty() {
		return this.cont==0;//
	}//isEmpty()


	@Override
	public Object top() throws PilaExceptions{
		if(isEmpty()) {
			throw new PilaExceptions("No hay tope, la pila vacia");
		}
		
		return top.element;
	}//top()


	@Override
	public void push(Object element) {
		Nodo nuevoNodo=new Nodo(element);
		
		if(top==null) {
			top=nuevoNodo;
		}else {
			nuevoNodo.next=top;
			top=nuevoNodo;
		}
		cont++;
	}//push()


	@Override
	public Object pop() throws PilaExceptions{
		if(isEmpty()) {
			throw new PilaExceptions("Pila vacia, no se puede hacer POP");
		}
		Object element=top.element;
		top=top.next;
		cont--;//restamos un valor
		
		return element;
	}//pop()
	
	
	public String toString() {
		
		Nodo aux=top;
		String result="Informacion de la pila";
		
		while(aux!=null) {
			result+="\n"+aux.element;
			aux=aux.next;
		}//while()
		
		return result;
	}//toString()

}//Fin de la clase
