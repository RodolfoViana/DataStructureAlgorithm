package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

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

	@Override
	public boolean isEmpty() {
		boolean resp = false;
		resp = this.getNext() == null;
		return resp;
	}

	@Override
	public boolean full() {

		boolean resp = false;

		if (size() >= eda.util.Constants.MAX_SIZE_OF_STRUCTURE) {
			resp = true;
		}
		return resp;
	}

	@Override
	public int size() {
		int size = 0;
		if (this.getNext() != null) {
			size = 1 + this.getNext().size();
		}
		return size;
	}

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

	@Override
	public LinkedList<E> revert() {
		DoubleLinkedListRecursiveImpl<E> resp = new DoubleLinkedListRecursiveImpl<E>();

		if (!isEmpty()) {
			resp = (DoubleLinkedListRecursiveImpl<E>) getNext().revert();

			// se eu mudar a assinatura do metodo nao precisa desse try, mas nao
			// sei se a gente pode fazer isso
			try {
				resp.insert(getElement());
			} catch (ADTOverflowException e) {
				e.printStackTrace();
			}
		}

		return resp;
	}

	@Override
	public int maximum() {
		int resp = (Integer) this.getElement();

		if (!isEmpty() && !getNext().isEmpty()) {
			if ((Integer) this.getElement() < (Integer) ((DoubleLinkedListRecursiveImpl<E>) getNext())
					.getElement()) {
				resp = (Integer) ((DoubleLinkedListRecursiveImpl<E>) getNext())
						.getElement();
				if (((DoubleLinkedListRecursiveImpl<E>) getNext()).getNext() == null) {
					return resp;
				} else {
					this.getNext().maximum();
				}

			}
		}
		return resp;
	}

	@Override
	public int minimum() {
		int resp = (Integer) this.getElement();

		if (!isEmpty() && !getNext().isEmpty()) {
			if ((Integer) this.getElement() > (Integer) ((DoubleLinkedListRecursiveImpl<E>) getNext())
					.getElement()) {
				resp = (Integer) ((DoubleLinkedListRecursiveImpl<E>) getNext())
						.getElement();
				if (((DoubleLinkedListRecursiveImpl<E>) getNext()).getNext() == null) {
					return resp;
				}

				else {
					this.getNext().minimum();
				}
			}
		}
		return resp;

	}

	@Override
	public boolean isHead() {

		boolean resp = false;
		resp = this.getBefore() == null && this.getNext() != null;
		return resp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public DoubleLinkedList<E> addFirst(int numero) throws ADTOverflowException {

		if (this.full()) {
			throw new ADTOverflowException();
		} else {

			@SuppressWarnings("rawtypes")
			DoubleLinkedListRecursiveImpl newHead = new DoubleLinkedListRecursiveImpl();

			newHead.setElement(numero);
			newHead.setNext(this);
			this.setBefore(newHead);

			return newHead;
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addLast(int numero) throws ADTOverflowException {
		if (this.isEmpty()) {

			// nao sei fazer de forma diferente, mas acho que ta errado
			// dessa forma que fiz
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
