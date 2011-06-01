package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;

/**
 * The node of a non recursive linked list. This class is recursive.
 * Fill the class.
 */
class SingleLinkedListNode<E>{
	
	private Object element;
	private SingleLinkedListNode next;
	private SingleLinkedListNode before;
	private E value;
	
	public SingleLinkedListNode(SingleLinkedListNode next, E value) {
		this.next=next;
		this.value=value;
	}
	
	public boolean isEmpty() {
		boolean resp = false;

		if (element == null) {
			resp = true;
		}

		return resp;
	}
	
	public SingleLinkedListNode getNext() {
		return next;
	}
	
	public E getValue() {
		return value;
	}
	
	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}
	
	
	public Object getElement() {
		return element;
	}
	
	public SingleLinkedListNode getBefore() {
		return before;
	}
	
	public void setBefore(SingleLinkedListNode before) {
		this.before = before;
	}
	
}

/**
 * Estrutura representa uma lista simples implementada de forma nao recursiva. 
 * Os metodos podem ser recursivos (recomendado) e nao precisam ser definidos
 * na classe SingleListNode.
 * A estrutura guarda apenas o no inicial (head) da lista. 
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode 
 * crescer e um FATOR de crescimento. Quando instanciada a estrutura tem um tamanho 
 * inicial. Quando ela vai crescendo e enche, ela aumenta de tamanho de acordo com o 
 * fator de crescimento desde que nao atinja ou ultrapasse o tamanho  maximo. A partir 
 * dai a estrutura nao pode mais crescer e pode ficar cheia. Use as constantes 
 * definidas em eda.util.Constantes para inicializar os valores internos de sua 
 * estrutura. Faca protected qualquer outro metodo auxiliar.
 */
public class SingleLinkedListNonRecursiveImpl<E> implements LinkedList<E> {
	
	private SingleLinkedListNode head;
	private SingleLinkedListNode tail;
	private int size;

	public SingleLinkedListNonRecursiveImpl() {
		size=0;
	}
	
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}


	/**
     * @return True caso a pilha esteja cheia, false caso contrario
     */
	@Override
	public boolean full() {
		boolean resp =  size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE;
		return resp;
	}
    
    /**
     * @return O numero de elementos da lista
     */
	@Override
	public int size() {
		return size;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(E element) throws ADTOverflowException {
		
		if (isEmpty()) {
			tail = head = new SingleLinkedListNode(null, element);
			size++;
		} else {
			if (!full()) {
				SingleLinkedListNode aux = head;
				
				for (int i = 0; i < size()-1; i++) {
					aux = aux.getNext();
				}	
				SingleLinkedListNode newNo = new SingleLinkedListNode(null, element);
				aux.setNext(newNo);
				size++;
			} else {
				throw new ADTOverflowException();
			}
		}
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int search(E element) throws ADTNoSuchElement {
		
		SingleLinkedListNode elementohead = head;
		SingleLinkedListNode resp = null;

		for (int i = 0; i < size() / 2; i++) {
			if (elementohead.getValue() == element) {
				resp = elementohead;
				break;
			}

			else {
				elementohead = elementohead.getNext();
			}
		}

		if (resp == null) {
			throw new ADTNoSuchElement();
		}

		return (Integer) resp.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(E element) {
		
		SingleLinkedListNode elementoHead = head;
		SingleLinkedListNode elementoTail = tail;
		boolean hasElement = false;

		if (size() == 1) {
			head = tail = new SingleLinkedListNode(null, element);
			size--;
		} else {

			for (int i = 0; i < (size() / 2) + 1; i++) {
				if (elementoHead.getValue() == element) {
					hasElement = true;					
					if (elementoHead.getValue() == head.getValue()){
						elementoHead.getNext().setBefore(null);
						head = elementoHead.getNext();						
						}
					size--;
					break;
			}			
				if (elementoTail.getValue() == element) {
					hasElement = true;
					elementoTail.getBefore().setNext(elementoTail.getNext());
					size--;
					break;
				} else {
					elementoHead = elementoHead.getNext();
					elementoTail = elementoTail.getBefore();
				}
			}
		}
		
//		try {
//			int position = search(element);
//			
//			SingleLinkedListNode<E> it = head;
//			int count = 0;
//			
//			while (it.getNext()!=null) {
//				if (count==position) {
//					it.setNext(it.getNext());
//				}
//				it=it.getNext();
//				count++;
//			}
//			size--;
//		} catch (ADTNoSuchElement e) {
//			return;
//		}
	}

	@Override
	public LinkedList<E> revert() {
		int elementNumber = size;
		
		LinkedList<E> result = new SingleLinkedListNonRecursiveImpl<E>();
		
		while (elementNumber>=0) {
			try {
				result.insert(getAtIndex(elementNumber).getValue());
			} catch (ADTOverflowException e) {}
			elementNumber--;
		}
		
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int maximum() {
		E resp = null;

		SingleLinkedListNode aux = head;

		for (int i = 0; i < size(); i++) {
			if (resp == null) {
				resp = (E) aux.getValue();
			} else {
				if ((Integer) resp < (Integer) aux.getValue()) {
					resp = (E) aux.getValue();
				}
			}
			aux = (SingleLinkedListNode) aux.getNext();
		}

		return (Integer) resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int minimum() {
		E resp = null;

		@SuppressWarnings("rawtypes")
		SingleLinkedListNode aux = head;

		for (int i = 0; i < size(); i++) {
			if (resp == null) {
				resp = (E) aux.getValue();
			} else {
				if ((Integer) resp > (Integer) aux.getValue()) {
					resp = (E) aux.getValue();
				}
			}
			aux = (SingleLinkedListNode) aux.getNext();
		}

		return (Integer) resp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(){
		E[] resp = (E[]) new Object[size()];

		SingleLinkedListNode aux = head;

		for (int i = 0; i < size(); i++) {
			resp[i] = (E) aux.getValue();
			aux = (SingleLinkedListNode) aux.getNext();
		}

		return resp;		
	}
	
	
	//metodos auxiliares
	
	@SuppressWarnings("unchecked")
	private SingleLinkedListNode<E> getAtIndex(int index) {
		SingleLinkedListNode<E> it = head;
		int count = 0;
		
		while (it.getNext()!=null) {
			if (index==count) {
				return it;
			}
			it=it.getNext();
			count++;
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String toString() {
		String resp = "{";

		SingleLinkedListNode aux = head;

		for (int i = 0; i < size(); i++) {
			resp = resp + ((E) aux.getValue()).toString() + ",";
			aux = (SingleLinkedListNode) aux.getNext();
		}

		resp = resp + "}";
		resp = resp.replaceFirst(",}", "}");
		
		return resp;
	}

}
