package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

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
public class SingleLinkedListRecursiveImpl<E> implements LinkedList<E> {

	private E element;
	private LinkedList<E> next;

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
		int size = 0;
		if(this.getNext() != null){ 
			size = 1 + this.getNext().size();
		}
		return size;
	}

	/**
	 * Insere um elemento na lista
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(E element) throws ADTOverflowException {
		if (this.isEmpty()) {
			this.setElement(element);
			this.setNext(new SingleLinkedListRecursiveImpl());
		} else {
			if (this.full()) {
				throw new ADTOverflowException();
			} else {
				((SingleLinkedListRecursiveImpl) this.getNext()).insert(element);
			}
		}
	}

	/**
	 * Pesuisa um elemento na lista
	 */
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void remove(E element) { 
		if (!isEmpty()){ 
			if(this.element == element){ 
				this.element = (E)((SingleLinkedListRecursiveImpl) next).getElement();
				this.next = ((SingleLinkedListRecursiveImpl) this.getNext()).getNext(); 
			} else {
				((LinkedList<E>) this.next).remove(element); } }
	}

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public LinkedList<E> revert() {
		
		SingleLinkedListRecursiveImpl<E> resp = new SingleLinkedListRecursiveImpl<E>();

		if (!isEmpty()) {
			resp = (SingleLinkedListRecursiveImpl<E>) getNext().revert();
			try {
				resp.insert(getElement());
			} catch (ADTOverflowException e) {
				e.printStackTrace();
			}
		}
	
		return resp;
	}

	/**
	 * Metodo que retorna o maior valor de uma lista
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int maximum() {
		E resp = null;

		SingleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			if (resp == null){
				resp = (E) aux.getElement();
			} else {
				if ((Integer) resp < (Integer) aux.getElement()){
					resp = (E) aux.getElement();
				}
			}
			aux = (SingleLinkedListRecursiveImpl) aux.getNext();
		}

		return (Integer) resp;
	}

	/**
	 * Metodo que retorna o menor valor de uma lista
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int minimum() {
		E resp = null;

		SingleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			if (resp == null){
				resp = (E) aux.getElement();
			} else {
				if ((Integer) resp > (Integer) aux.getElement()){
					resp = (E) aux.getElement();
				}
			}
			aux = (SingleLinkedListRecursiveImpl) aux.getNext();
		}

		return (Integer) resp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public E[] toArray() {
		E[] array = (E[]) new Object[size()];
		
		SingleLinkedListRecursiveImpl aux = this;
		
		  for (int i = 0; i < size(); i++) {
			array[i] = (E) aux.getElement();
			aux = (SingleLinkedListRecursiveImpl) aux.getNext();
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

	@SuppressWarnings("rawtypes")
	public LinkedList getNext() {
		return next;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public E last() throws ADTUnderflowException {
		E elementoRemovido = getElement();
		
		if (isEmpty()) {
			throw new ADTUnderflowException();
		}
		if (getNext().isEmpty()) {
			elementoRemovido = getElement();
		} else {
			elementoRemovido = (E) ((SingleLinkedListRecursiveImpl) getNext()).last();
		}
		
		return elementoRemovido;
	}
	
	public E removeLast() throws ADTUnderflowException{
		
		E ultimoElemento = last();
		remove(ultimoElemento);
		
		return ultimoElemento;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String toString() {
		String resp = "{";

		SingleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			resp = resp + ((E) aux.getElement()).toString() + ",";
			aux = (SingleLinkedListRecursiveImpl) aux.getNext();
		}

		resp = resp + "}";
		resp = resp.replaceFirst(",}", "}");

		return resp;
	}

}