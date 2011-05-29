package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * The node of a non recursive linked list. This class is recursive.
 * Fill the class.
 */
class DoubleLinkedListNode{
	
	private Object element;
	private DoubleLinkedListNode before;
	private DoubleLinkedListNode next;
	
	public DoubleLinkedListNode (Object element){
		this.element = element;
	}
	
	public boolean isEmpty() {
		boolean resp = false;
		
		if (element == null){
			resp = true;
		}
		
		return resp;
	}



	public Object getElement() {
		return element;
	}



	public void setElement(Object element) {
		this.element = element;
	}



	public DoubleLinkedListNode getBefore() {
		return before;
	}



	public void setBefore(DoubleLinkedListNode before) {
		this.before = before;
	}



	public DoubleLinkedListNode getNext() {
		return next;
	}



	public void setNext(DoubleLinkedListNode next) {
		this.next = next;
	}
	
	
	
}
/**
 * Estrutura representa uma lista dupla implementada de forma nao recursiva. 
 * Os metodos podem ser recursivos (recomendado) e nao precisam ser definidos
 * na classe DoubleListNode.
 * A estrutura guarda apenas o no inicial (head) da lista e tambem o ultimo no da lista, 
 * para possibilitar acesso pelo final da lista. 
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode 
 * crescer e um FATOR de crescimento. Quando instanciada a estrutura tem um tamanho 
 * inicial. Quando ela vai crescendo e enche, ela aumenta de tamanho de acordo com o 
 * fator de crescimento desde que nao atinja ou ultrapasse o tamanho  maximo. A partir 
 * dai a estrutura nao pode mais crescer e pode ficar cheia. Use as constantes 
 * definidas em eda.util.Constantes para inicializar os valores internos de sua 
 * estrutura. Faca protected qualquer outro metodo auxiliar.
 */
public class DoubleLinkedListNonRecursiveImpl<E> implements DoubleLinkedList<E> {
	
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	private int size;

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean full() {
		boolean resp = false;
		
		if (size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE ){
			resp = true;
		}
		return resp;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void insert(E element) throws ADTOverflowException {
		
		if (isEmpty()){
			tail = head = new DoubleLinkedListNode(element);
			size ++;
		} else {
			if (!full()){
				DoubleLinkedListNode newNo = new DoubleLinkedListNode(element);
				newNo.setBefore(tail);
				tail.setNext(newNo);
				tail = newNo;
				size ++;
			} else {
				throw new ADTOverflowException();
			}
		}
	}

	/**
	 * A procura pode ser feita nas duas direcoes (a aprtir do inicio e a partir 
	 * do final) Isso pode acontecer ao mesmo tempo, reduzindo o tempo de busca
	 * a O((1/2)*n).
	 */
	@Override
	public int search(E element) throws ADTNoSuchElement {
		DoubleLinkedListNode elementohead = head;
		DoubleLinkedListNode elementoTail = tail;
		DoubleLinkedListNode resp = null;
		
		for (int i = 0; i < size()/2 ; i++){
			if (elementohead.getElement() == element){
				resp = elementohead;
				break;
			} 
			
			if (elementoTail.getElement() == element){
				resp = elementoTail;
				break;
			}
			
			else {
				elementohead = elementohead.getNext();
				elementoTail = elementoTail.getBefore();
			}
		} 
		
		if (resp == null){
			throw new ADTNoSuchElement();
		}
			
		return (Integer) resp.getElement();
	}

	@Override
	public void remove(E element) {
		DoubleLinkedListNode elementohead = head;
		DoubleLinkedListNode elementoTail = tail;
		boolean hasElement = false;
		
		if (isEmpty()){
//			throw new ADTUnderflowException();
		}
		
		if (size() == 1){
			head = tail = new DoubleLinkedListNode(null);
			size--;
		}
		else {
						
			for (int i = 0; i < size()/2 ; i++){
				if (elementohead.getElement() == element){
					hasElement = true;
					elementohead.getBefore().setNext(elementohead.getNext());
					elementohead.getNext().setBefore(elementohead.getBefore());
					size--;
					break;
				} 				
				if (elementoTail.getElement() == element){
					hasElement = true;
					elementoTail.getBefore().setNext(elementoTail.getNext());
					elementoTail.getNext().setBefore(elementoTail.getBefore());
					size--;
					break;
				}
				else {
					elementohead = elementohead.getNext();
					elementoTail = elementoTail.getBefore();
				}
			} 
			
			if (hasElement == false){
//				throw new ADTNoSuchElement();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<E> revert() {
		LinkedList<E> newLinked = new DoubleLinkedListNonRecursiveImpl<E>();
		DoubleLinkedListNode newNo = tail;
		
		for (int i = 0; i < size(); i ++){
			try {
				newLinked.insert((E) newNo.getElement());
				newNo = newNo.getBefore();
			} catch (ADTOverflowException e) {
				e.printStackTrace();
			}
		}
		return newLinked;
	}

	@Override
	public int maximum() {
		int resp = (Integer) head.getElement();
		
		DoubleLinkedListNode aux = head;
		
		for (int i = 0; i < size(); i++){
			if ((Integer) aux.getElement() < (Integer)((DoubleLinkedListNode) aux.getNext()).getElement()){
				resp = (Integer)((DoubleLinkedListNode) aux.getNext()).getElement();
			}
			
			aux = aux.getNext();
		}
			
		return resp;
	}

	@Override
	public int minimum() {
		int resp = (Integer) head.getElement();
		
		DoubleLinkedListNode aux = head;
		
		for (int i = 0; i < size(); i++){
			if ((Integer) aux.getElement() > (Integer)((DoubleLinkedListNode) aux.getNext()).getElement()){
				resp = (Integer)((DoubleLinkedListNode) aux.getNext()).getElement();
			}
			aux = aux.getNext();
		}
			
		return resp;
	}

	@SuppressWarnings({"unchecked" })
	@Override
	public E[] toArray() {
		E[] resp = (E[]) new Object[size()];
		
		DoubleLinkedListNode aux = head;
		
		for (int i = 0; i < size(); i++){
			resp[i] = (E) aux.getElement();
			aux = (DoubleLinkedListNode) aux.getNext();
		}	
		
		return resp;
	}

	@Override
	public boolean isHead() {
		return isEmpty() == false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DoubleLinkedList<E> addFirst(int numero) throws ADTOverflowException {
		DoubleLinkedListNode newNo = null;
		
		if (isEmpty()){
			tail = head = new DoubleLinkedListNode(numero);
			size ++;
		} else {
			if (!full()){
				newNo = new DoubleLinkedListNode(numero);
				
				newNo.setNext(head);
				head.setBefore(newNo);
				head = newNo;
				size++;
			} else {
				throw new ADTOverflowException();
			}
		}
		return (DoubleLinkedList<E>) newNo;
	}

	@Override
	public void addLast(int numero) throws ADTOverflowException {
		
		if (isEmpty()){
			tail = head = new DoubleLinkedListNode(numero);
			size ++;
		} else {
			if (!full()){
				DoubleLinkedListNode newNo = new DoubleLinkedListNode(numero);
				newNo.setBefore(tail);
				tail.setNext(newNo);
				tail = newNo;
				size ++;
			} else {
				throw new ADTOverflowException();
			}
		}
	}

	@Override
	public void removeFirst() throws ADTUnderflowException {
		if (isEmpty()){
			throw new ADTUnderflowException();
		}
		
		if (size() == 1){
			head = tail = new DoubleLinkedListNode(null);
			size--;
		}
		else {
			head = head.getNext();
			head.setBefore(null);
			size--;
		} 
	}

	@Override
	public void removeLast() throws ADTUnderflowException {
		if (isEmpty()){
			throw new ADTUnderflowException();
		}
		
		if (size() == 1){
			head = tail = new DoubleLinkedListNode(null);
			size--;
		}
		else {
			tail = tail.getBefore();
			tail.setNext(null);
			size--;
		} 

	}
	
	@SuppressWarnings({ "unchecked" })
	@Override 
	public String toString(){
		String resp = "{";
		
		DoubleLinkedListNode aux = head;
		
		for (int i = 0; i < size(); i++){
			resp = resp + ((E) aux.getElement()).toString() + ",";
			aux = (DoubleLinkedListNode) aux.getNext();
		}
		
		resp = resp + "}";
		resp = resp.replaceFirst(",}", "}");
		
		return resp;
	}


}
