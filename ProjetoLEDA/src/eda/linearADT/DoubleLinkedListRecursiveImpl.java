package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * Universidade Federal de Campina Grande
 * Projetos de Laboratorio de Estrutura de Dados
 * 
 * Equipe:  Layse Sobreira
 * 			Renan Pinto
 * 			Rodolfo Viana
 * 			Talita Lobo

 * 
 * 	Implementacao das Estruturas Lineares
 * 		Lista Dupla, Lista Simples, Fila e Pilha
 *          Implementacao da Lista Duplamente Ligada Recursiva
 */

/**
 * Estrutura representa uma lista dupla implementada de forma recursiva. Ela
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
 * 
 * @param <T>
 */
public class DoubleLinkedListRecursiveImpl<E> implements DoubleLinkedList<E> {

	private E element;
	private DoubleLinkedList<E> next;
	private DoubleLinkedList<E> before;

	/**
	 * Verifica se a(s) lista(s) esta(ao) vazia(s).
	 */
	@Override
	public boolean isEmpty() {
		boolean resp = false;
		resp = this.getNext() == null;
		return resp;
	}

	/**
	 * Verifica se a(s) lista(s) esta(ao) cheia(s).
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
	 * Verifica o tamanho da(s) lista(s).
	 */
	@Override
	public int size() {
		int size = 0;
		if (this.getNext() != null) {
			size = 1 + this.getNext().size();
		}
		return size;
	}

	/**
	 * Insere o elemento na(s) lista(s).
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void insert(E element) throws ADTOverflowException {
		if (this.isEmpty()) {
			this.setElement(element);
			this.setNext(new DoubleLinkedListRecursiveImpl());
			((DoubleLinkedListRecursiveImpl) getNext()).setBefore(this);
		} else {

			if (this.full()) {
				throw new ADTOverflowException();
			} else {
				((DoubleLinkedListRecursiveImpl) this.getNext())
						.insert(element);
			}
		}
	}

	/**
	 * Procura o elemento na(s) lista(s).
	 */
	@Override
	public int search(E element) throws ADTNoSuchElement {
		int retorno = -1;

		if (isEmpty()) {
			throw new ADTNoSuchElement();
		} else {
			if (this.element == element) {
				retorno = (Integer) element;
			} else {
				retorno = this.next.search(element);
			}
		}
		return retorno;
	}

	/**
	 * Remove o elemento da(s) lista(s).
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void remove(E element) {

		if (!isEmpty()) {
			if (this.element == element) {
				this.element = (E) ((DoubleLinkedListRecursiveImpl) next)
						.getElement();
				this.next = ((DoubleLinkedListRecursiveImpl) this.getNext())
						.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	/**
	 * Reverte um elemento na(s) lista(s).
	 */
	@Override
	public LinkedList<E> revert() {
		DoubleLinkedListRecursiveImpl<E> resp = new DoubleLinkedListRecursiveImpl<E>();

		if (!isEmpty()) {
			resp = (DoubleLinkedListRecursiveImpl<E>) getNext().revert();
			try {
				resp.insert(getElement());
			} catch (ADTOverflowException e) {
				e.printStackTrace();
			}
		}

		return resp;
	}

	/**
	 * Retorna o maior elemento da(s) lista(s).
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int maximum() {
		E resp = null;

		DoubleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			if (resp == null){
				resp = (E) aux.getElement();
			} else {
				if ((Integer) resp < (Integer) aux.getElement()){
					resp = (E) aux.getElement();
				}
			}
			aux = (DoubleLinkedListRecursiveImpl) aux.getNext();
		}

		return (Integer) resp;
	}

	/**
	 * Retorna o menor elemento da(s) lista(s).
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int minimum() {
		E resp = null;

		DoubleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			if (resp == null){
				resp = (E) aux.getElement();
			} else {
				if ((Integer) resp > (Integer) aux.getElement()){
					resp = (E) aux.getElement();
				}
			}
			aux = (DoubleLinkedListRecursiveImpl) aux.getNext();
		}

		return (Integer) resp;

	}

	/**
	 * Verifica se o elemento eh a cabeca.
	 */
	@Override
	public boolean isHead() {

		boolean resp = false;
		resp = this.getBefore() == null && this.getNext() != null;
		return resp;
	}

	/**
	 * Adiciona primeiro o elemento a lista.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DoubleLinkedList<E> addFirst(int numero) throws ADTOverflowException {

		if (this.full()) {
			throw new ADTOverflowException();
		} else {

			@SuppressWarnings("rawtypes")
			DoubleLinkedListRecursiveImpl newHead = new DoubleLinkedListRecursiveImpl();

			newHead.setElement(getElement());
			newHead.setNext(getNext());
			newHead.setBefore(this);
			
			this.setElement((E)(Object)numero);
			this.setNext(newHead);
			
			return this;
		}

	}

	/**
	 * Adiciona no fim o elemento na lista.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addLast(int numero) throws ADTOverflowException {
		if (this.isEmpty()) {
			Object newNumero = (Object) numero;

			this.setElement((E) newNumero);
			this.setNext(new DoubleLinkedListRecursiveImpl());
			((DoubleLinkedListRecursiveImpl) getNext()).setBefore(this);
		} else {

			if (this.full()) {
				throw new ADTOverflowException();
			} else {
				((DoubleLinkedListRecursiveImpl) this.getNext())
						.addLast(numero);
			}
		}
	}

	/**
	 * Remove primeiro o elemento na lista.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void removeFirst() throws ADTUnderflowException {

		if (!isEmpty()) {
			if (isHead()) {
				this.element = (E) ((DoubleLinkedListRecursiveImpl) next)
						.getElement();
				this.next = ((DoubleLinkedListRecursiveImpl) this.getNext())
						.getNext();
			}

		} else {
			throw new ADTUnderflowException();
		}
	}

	/**
	 * Remove por ultimo o elemento da lista.
	 */
	@Override
	public void removeLast() throws ADTUnderflowException {

		if (isEmpty()) {
			throw new ADTUnderflowException();
		}
		if (getNext().isEmpty()) {
			remove(getElement());
		} else {
			getNext().removeLast();
		}
	}

	/**
	 * Retorna o toArray da LinkedList
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public E[] toArray() {

		E[] resp = (E[]) new Object[size()];

		DoubleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			resp[i] = (E) aux.getElement();
			aux = (DoubleLinkedListRecursiveImpl) aux.getNext();
		}

		return resp;
	}

	/**
	 * metodo equals.
	 */
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;

		if (!(obj instanceof DoubleLinkedList)) {
			return false;
		}

		@SuppressWarnings("rawtypes")
		DoubleLinkedListRecursiveImpl newObj = (DoubleLinkedListRecursiveImpl) obj;

		if (newObj.size() == this.size()) {
			if (isEmpty() == newObj.isEmpty()) {
				return true;
			} else {
				if (newObj.getElement().equals(this.getElement())) {
					getNext().equals(newObj.getNext());
					resp = true;
				} else {
					resp = false;
				}
			}

		}

		return resp;
	}

	/**
	 * toString
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String toString() {
		String resp = "{";

		DoubleLinkedListRecursiveImpl aux = this;

		for (int i = 0; i < size(); i++) {
			resp = resp + ((E) aux.getElement()).toString() + ",";
			aux = (DoubleLinkedListRecursiveImpl) aux.getNext();
		}

		resp = resp + "}";
		resp = resp.replaceFirst(",}", "}");

		return resp;
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public DoubleLinkedList<E> getNext() {
		return next;
	}

	public void setNext(DoubleLinkedList<E> next) {
		this.next = next;
	}

	public DoubleLinkedList<E> getBefore() {
		return before;
	}

	public void setBefore(DoubleLinkedList<E> before) {
		this.before = before;
	}

}
