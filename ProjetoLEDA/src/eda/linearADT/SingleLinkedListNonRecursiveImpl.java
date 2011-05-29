package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;

/**
 * The node of a non recursive linked list. This class is recursive.
 * Fill the class.
 */
class SingleLinkedListNode<E>{
	
	private SingleLinkedListNode next;
	private E value;
	
	public SingleLinkedListNode(SingleLinkedListNode next, E value) {
		this.next=next;
		this.value=value;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
public class SingleLinkedListNonRecursiveImpl<E extends Comparable<E>> implements LinkedList<E> {
	
	private SingleLinkedListNode<E> head;
	private SingleLinkedListNode<E> next;
	private int size;

	public SingleLinkedListNonRecursiveImpl() {
		head=null;
		next=null;
		size=0;
	}
	
	@Override
	public boolean isEmpty() {
		boolean resp = head==null;
		return resp;
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

	@SuppressWarnings("unchecked")
	@Override
	public void insert(E element) throws ADTOverflowException {
		if (!full()) {
			next.setNext(new SingleLinkedListNode<E>(null, element));
			next=next.getNext();
			size++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int search(E element) throws ADTNoSuchElement {
		
		if (head==null) throw new ADTNoSuchElement();
		
		SingleLinkedListNode<E> it = head;
		int count = 0;
		
		while (it.getNext()!=null) {
			if (it.getValue().equals(element)) {
				return count;
			}
			it=it.getNext();
			count++;
		}
		
		return -1;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void remove(E element) {
		try {
			int position = search(element);
			
			SingleLinkedListNode<E> it = head;
			int count = 0;
			
			while (it.getNext()!=null) {
				if (count==position) {
					it.setNext(it.getNext());
				}
				it=it.getNext();
				count++;
			}
			size--;
		} catch (ADTNoSuchElement e) {
			return;
		}
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

	@SuppressWarnings("unchecked")
	@Override
	public int maximum() {
		if (head==null) return -1;
		SingleLinkedListNode<E> it = head;
		SingleLinkedListNode<E> max = head;
		
		while (it.getNext()!=null) {
			if (max.getValue().compareTo(it.getValue())<0) {
				max=it;
			}
			it=it.getNext();
		}
		
		try {
			return search(max.getValue());
		} catch (ADTNoSuchElement e) {
			return -1;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int minimum() {
		if (head==null) return -1;
		SingleLinkedListNode<E> it = head;
		SingleLinkedListNode<E> min = head;
		
		while (it.getNext()!=null) {
			if (min.getValue().compareTo(it.getValue())>0) {
				min=it;
			}
			it=it.getNext();
		}
		
		try {
			return search(min.getValue());
		} catch (ADTNoSuchElement e) {
			return -1;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(){
		Object[] result = new Object[size];
		
		SingleLinkedListNode<E> it = head;
		int count = 0;
		
		while (it.getNext()!=null) {
			result[count]=it.getValue();
			it=it.getNext();
			count++;
		}
		
		return (E[]) result;
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

}
