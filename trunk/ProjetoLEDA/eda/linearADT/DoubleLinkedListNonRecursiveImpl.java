package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * The node of a non recursive linked list. This class is recursive.
 * Fill the class.
 */
class DoubleLinkedListNode{
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert(E element) throws ADTOverflowException {
		// TODO Auto-generated method stub

	}

	/**
	 * A procura pode ser feita nas duas direcoes (a aprtir do inicio e a partir 
	 * do final) Isso pode acontecer ao mesmo tempo, reduzindo o tempo de busca
	 * a O((1/2)*n).
	 */
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
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHead() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DoubleLinkedList<E> addFirst(int numero) throws ADTOverflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLast(int numero) throws ADTOverflowException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFirst() throws ADTUnderflowException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeLast() throws ADTUnderflowException {
		// TODO Auto-generated method stub

	}

}
