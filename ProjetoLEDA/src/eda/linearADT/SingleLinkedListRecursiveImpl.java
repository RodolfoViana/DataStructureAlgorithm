package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;
import eda.util.Constants;

/**
 * Universidade Federal de Campina Grande
 * Projetos de Laboratorio de Estrutura de Dados
 * 
 * Equipe: Renan Pinto
 *         Layse Sobreira
 *         Rodolfo Viana
 *         Talita Lobo
 * 
 *      Implementacao das Estruturas Lineares
 *              Lista Dupla, Lista Simples, Fila e Pilha
 *                      SingleLinkedListRecursiveImpl - Implementacao de Uma Lista Simplesmente Encadeada Não Recursiva.
 */

/**
 * Estrutura representa um alista simples implementada de forma recursiva. Ela
 * representa um no da lista que deve er ligado a outros e todos os metodos
 * devem ser definidos nessa classe, de forma recursiva dentro de cada no, como
 * visto em sala de aula. A estrutura deve ter um tamanho inicial, um tamanho
 * maximo que pode crescer e um FATOR de crescimento. Quando instanciada a
 * estrutura tem um tamanho inicial. Quando ela vai crescendo e enche, ela
 * aumenta de tamanho de acordo com o fator de crescimento desde que nao atinja
 * ou ultrapasse o tamanho maximo. A partir dai a estrutura nao pode mais
 * crescer e pode ficar cheia. Use as constantes definidas em
 * eda.util.Constantes para inicializar os valores internos de sua estrutura.
 * Faca protected qualquer outro metodo auxiliar.
 */
public class SingleLinkedListRecursiveImpl<E extends Comparable<E>> implements
		LinkedList<E> {

	private E element;
	@SuppressWarnings("rawtypes")
	private SingleLinkedListNode head;
	@SuppressWarnings("rawtypes")
	private SingleLinkedListNode next;
	private int size = 0;
	private E[] array;

	public SingleLinkedListRecursiveImpl() {
		array = (E[]) new Object[eda.util.Constants.INITIAL_SIZE_OF_STRUCTURE];
		head = null;
		next = head;
	}

	/**
	 * @return True caso a lista esteja vazia, false caso contrario
	 */
	@Override
	public boolean isEmpty() {
		boolean resp = false;

		if (this.next == null) {
			resp = true;
		}
		return resp;
	}

	/**
	 * @return True caso a pilha esteja cheia, false caso contrario
	 */
	@Override
	public boolean full() {
		boolean resp = false;

		if (size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE) {
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

	/**
	 * Insere um elemento na lista
	 */
	@Override
	public void insert(E element) throws ADTOverflowException {
		if (!full()) {
			this.next = new SingleLinkedListNode<E>(null, element);
			this.next = this.next.getNext();
			size++;
		}
	}

	/**
	 * Pesuisa um elemento na lista
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int search(E element) throws ADTNoSuchElement {
		int resp = -1;

		if (isEmpty()) {
			throw new ADTNoSuchElement();
		} else {
			if (this.element == element) {
				resp = (Integer) element;
			} else {
				resp = ((LinkedList<E>) this.next).search(element);
			}
		}
		return resp;
	}

	/**
	 * Remove um elemento na lista
	 */
	@Override
	public void remove(E element) {
		/*
		 * vou ajeitar os erros
		 * 
		 * if (!isEmpty()){ if(this.element == element){ this.element =
		 * (E)((SingleLinkedListNode) next).getElement(); this.next =
		 * ((SingleLinkedListNode) this.getNext()).getNext(); } else {
		 * ((LinkedList<E>) this.next).remove(element); } }
		 */
	}

	/**
	 * 
	 */
	@Override
	public LinkedList<E> revert() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Metodo que retorna o maior valor de uma lista
	 */
	@Override
	public int maximum() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Metodo que retorna o menor valor de uma lista
	 */
	@Override
	public int minimum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E[] toArray() {
		SingleLinkedListNode elemento = head;
		for (int i = 0; i < size(); i++) {
			array[i] = (E) elemento.getValue();
			elemento = elemento.getNext();
		}
		return array;
	}

	// metodos auxiliares

	/**
	 * @return element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element
	 */
	public void setElement(E element) {
		this.element = element;
	}

}