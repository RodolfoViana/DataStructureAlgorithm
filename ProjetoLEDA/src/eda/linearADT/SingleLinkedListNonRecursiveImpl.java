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
public class SingleLinkedListNonRecursiveImpl<E> implements LinkedList<E> {
	
	private SingleLinkedListNode next;
	private int size = 0;
	
	/**
     * @return True caso a lista esteja vazia, false caso contrario
     */
	@Override
	public boolean isEmpty() {
		boolean resp = false;
        
        if (this.next == null){
            resp = true;
        }
        return resp;
	}

	/**
     * @return True caso a lista esteja cheia, false caso contrario
     */
    @Override
	public boolean full() {
		boolean resp = false;
		
		if (size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE ){
			resp = true;
		}
		return resp;
	}
    
    /**
     * @return O numero de elementos da lista
     */
	@Override
	public int size() {
		return size;
	}

	@Override
	public void insert(E element) throws ADTOverflowException {
		// TODO Auto-generated method stub

	}

	@Override
	public int search(E element) throws ADTNoSuchElement {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<E> revert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maximum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int minimum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public E[] toArray(){
		// TODO Auto-generated method stub
		return null;
	}

}
