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
 * Estrutura que guarda elementos seguindo a politica FIFO, 
 * mas que utiliza filas (Queue) internamente para guardar (e nao array puro). 
 * Pode usar quantas filas achar necessario, mas o limite minimo de 2 para essa implementacao.
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode crescer e um FATOR 
 * de crescimento. Quando instanciada a estrutura tem um tamanho inicial. Quando ela vai 
 * crescendo e enche, ela aumenta de tamanho de acordo com o fator de crescimento
 * desde que nao atinja ou ultrapasse o tamanho  maximo. A partir dai a estrutura
 * nao pode mais crescer e pode ficar cheia. Use as constrantes definidas
 * em eda.util.Constantes para inicializar os valores internos de sua estrutura.
 * Faca protected qualquer outro metodo auxiliar.
 */


public class StackQueueImpl<E> implements Stack<E> {

	// implementar uma pilha usando fila
	
	// usar duas filas
	private Queue<Object> queue;
	private Queue<Object> queue2;
	
	private int tamanhoMaximo;
	private final int FATOR = Constants.INCREASING_FACTOR;
	
	/**
	 * Construtor de uma pilha usando duas filas.
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "rawtypes" })
	public StackQueueImpl() {
		tamanhoMaximo = Constants.MAX_SIZE_OF_STRUCTURE;
		
		queue = (Queue) new Object();
		queue2 = (Queue) new Object();
	}
	
	/**
	 * Insere um elemento na pilha, usando duas filas.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void push(E element) throws ADTOverflowException {
		
		if (queue.full()) {
			throw new ADTOverflowException();
		} else if (queue.size() == tamanhoMaximo) {
			throw new ADTOverflowException();
		} else {
			queue.enqueue(element);
		}
		
	}

	/**
	 * Remove um elemento na pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws ADTUnderflowException {
		E delete = null;
		if(isEmpty()){
			throw new ADTUnderflowException();
		} else {
			if(!queue.isEmpty()){
				delete = (E) queue.dequeue();
			}else if (!queue2.isEmpty()){
				delete = (E) queue2.dequeue();
			}
		} return delete;

	}

	/**
	 * Retorna o elemento que se encontra no topo da pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E top() throws ADTUnderflowException{
		E element;
		if (queue.isEmpty()) {
			throw new ADTUnderflowException();
		} else { 
			element = (E) queue.head();			
		}
		return element;	
	}

	/**
	 * Verifica se a pilha esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return queue.isEmpty() && queue2.isEmpty();
	}

	/**
	 * Verifica se a pilha esta cheia.
	 */
	@Override
	public boolean full() {
		return queue.full() || queue2.full();
	}
	
	/**
	 * Exibe a pilha.
	 */
	@Override
	public E[] toArray(){
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retorna o tamanho da pilha.
	 */
	@Override
	public int size() {
		int q1 = queue.size();
		int q2 = queue2.size();
		int resp = q2;
		
		if(q1 >= q2){
			resp = q1;
		}
		
		return resp;
	}


}
