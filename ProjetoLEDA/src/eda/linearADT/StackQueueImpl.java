package eda.linearADT;

import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;
import eda.util.Constants;

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
 * 			Pilha - Implementacao de Uma Pilha com duas Filas
 */

/**
 * Estrutura que guarda elementos seguindo a politica FIFO, mas que utiliza
 * filas (Queue) internamente para guardar (e nao array puro). Pode usar quantas
 * filas achar necessario, mas o limite minimo de 2 para essa implementacao. A
 * estrutura deve ter um tamanho inicial, um tamanho maximo que pode crescer e
 * um FATOR de crescimento. Quando instanciada a estrutura tem um tamanho
 * inicial. Quando ela vai crescendo e enche, ela aumenta de tamanho de acordo
 * com o fator de crescimento desde que nao atinja ou ultrapasse o tamanho
 * maximo. A partir dai a estrutura nao pode mais crescer e pode ficar cheia.
 * Use as constrantes definidas em eda.util.Constantes para inicializar os
 * valores internos de sua estrutura. Faca protected qualquer outro metodo
 * auxiliar.
 */

public class StackQueueImpl<E> implements Stack<E> {

	// implementar uma pilha usando fila

	// usar duas filas
	private Queue<E> q1, q2;

	private int tamanhoMaximo;
	private final int FATOR = Constants.INCREASING_FACTOR;
	private E element;
	private E[] array;

	/**
	 * Construtor de uma pilha usando duas filas.
	 */
	public StackQueueImpl() {
		tamanhoMaximo = Constants.MAX_SIZE_OF_STRUCTURE;
		q1 = new QueueImpl<E>();
		q2 = new QueueImpl<E>();
	}

	/**
	 * Insere um elemento na pilha, usando duas filas.
	 */
	@Override
	public void push(E element) throws ADTOverflowException {
		q1.enqueue(element);
	}

	/**
	 * @throws Remove
	 *             um elemento na pilha.
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws ADTUnderflowException {
		while (q1.size() > 1) {

			try {
				System.out.println(q1);
				q2.enqueue(q1.dequeue());
			} catch (ADTOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		E elem = q1.dequeue();
		q1 = q2;
		q2 = new QueueImpl<E>();
		return elem;

	}

	/**
	 * Retorna o elemento que se encontra no topo da pilha.
	 */
	@Override
	public E top() throws ADTUnderflowException{
		if (q1.isEmpty()) {
			throw new ADTUnderflowException();
		}
		return q1.toArray()[q1.size()-1];
	}

	/**
	 * Verifica se a pilha esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return q1.isEmpty() && q2.isEmpty();
	}

	/**
	 * Verifica se a pilha esta cheia.
	 */
	@Override
	public boolean full() {
		return q1.full() || q2.full();
	}

	/**
	 * Exibe a pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		for (int i = 0; i <= size(); i++) {
			array = (E[]) q1.toArray();
		}
		return array;
	}

	/**
	 * Retorna o tamanho da pilha.
	 */
	@Override
	public int size() {
		return q1.size() + q2.size();
	}

}
