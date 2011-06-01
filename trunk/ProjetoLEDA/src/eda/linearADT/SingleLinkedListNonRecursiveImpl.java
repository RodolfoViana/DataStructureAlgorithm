package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;

/**
 * The node of a non recursive linked list. This class is recursive.
 * Fill the class.
 */
class SingleLinkedListNode<E>{
	
	@SuppressWarnings("rawtypes")
	private SingleLinkedListNode next;
	@SuppressWarnings("rawtypes")
//	private SingleLinkedListNode before;
	private E value;
	
	public SingleLinkedListNode(E value) {
		this.value=value;
	}
	
	public boolean isEmpty() {
		boolean resp = false;

		if (value == null) {
			resp = true;
		}

		return resp;
	}
	
	@SuppressWarnings("rawtypes")
	public SingleLinkedListNode getNext() {
		return next;
	}
	
	public E getValue() {
		return value;
	}
	
	@SuppressWarnings("rawtypes")
	public void setNext(SingleLinkedListNode next) {
		this.next = next;
	}
	
	
//	@SuppressWarnings("rawtypes")
//	public SingleLinkedListNode getBefore() {
//		return before;
//	}
//	
//	@SuppressWarnings("rawtypes")
//	public void setBefore(SingleLinkedListNode before) {
//		this.before = before;
//	}
	
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
	
	@SuppressWarnings("rawtypes")
	private SingleLinkedListNode head;
	@SuppressWarnings("rawtypes")
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
			tail = head = new SingleLinkedListNode(element);
			size++;
		} else {
			if (!full()) {
				
				if (size() == 1){
					SingleLinkedListNode newNo = new SingleLinkedListNode(element);
					head.setNext(newNo);
					tail = newNo;
				} else {
					SingleLinkedListNode aux = tail;
					SingleLinkedListNode newNo = new SingleLinkedListNode(element);
					aux.setNext(newNo);
					tail = newNo;
				}
				
				size++;
			} else {
				throw new ADTOverflowException();
			}
		}
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	@Override
	public int search(E element) throws ADTNoSuchElement {
		
		SingleLinkedListNode elementohead = head;
		SingleLinkedListNode resp = null;

		for (int i = 0; i < size(); i++) {
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void remove(E element) {
		
//		SingleLinkedListNode elementoHead = head;
//		SingleLinkedListNode elementoTail = tail;
		SingleLinkedListNode anterior = null;
		SingleLinkedListNode atual = head;
		boolean hasElement = false;

		if (size() == 1) {
			head = tail = new SingleLinkedListNode(element);
			size--;
		} 
		else {
			if (atual.getValue() == element){
				head = atual.getNext();
				size--;
			} else {
				anterior = head;
				atual = head.getNext();
			

			for (int i = 0; i < size(); i++) {
				
				if (atual.getValue() == element) {
					hasElement = true;					
					if (atual.getValue() == tail.getValue()){
						anterior.setNext(null);
						tail = anterior;
					} else{
////						elementoHead.getNext().setBefore(null);
//						head = elementoHead.getNext();						
//						}
					anterior.setNext(atual.getNext());
					}
					size--;
					break;
			}
				
//				if (elementoTail.getValue() == element) {
//					hasElement = true;
////					elementoTail.getBefore().setNext(elementoTail.getNext());
//					size--;
//					break;
//				} 
			else {
					atual = atual.getNext();
					anterior = anterior.getNext();
//					elementoTail = elementoTail.getBefore();
				}
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public LinkedList<E> revert() {
		
		LinkedList<E> newLinked = new SingleLinkedListNonRecursiveImpl<E>();
		SingleLinkedListNode newNo = tail;
		int size = size();
		
		for (int i = 0; i < size; i++) {
			try {
				newNo = tail;
				newLinked.insert((E) newNo.getValue());
				remove((E) tail.getValue());
				newNo = tail;
			} catch (ADTOverflowException e) {
				e.printStackTrace();
			}
		}
		
		return newLinked;
		
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
