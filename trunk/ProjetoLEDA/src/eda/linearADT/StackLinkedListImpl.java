package eda.linearADT;

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
 * 			Pilha - Implementacao Recursiva
 */

/**
 * IMPLEMENTACAO RECURSIVA
 * Estrutura que guarda elementos seguindo a politica FIFO, mas que utiliza
 * UMA SingleLinkedListRecursiveImpl internamente para guardar os dados. 
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode crescer e um FATOR 
 * de crescimento. Quando instanciada a estrutura tem um tamanho inicial. Quando ela vai 
 * crescendo e enche, ela aumenta de tamanho de acordo com o fator de crescimento
 * desde que nao atinja ou ultrapasse o tamanho  maximo. A partir dai a estrutura
 * nao pode mais crescer e pode ficar cheia. Use as constrantes definidas
 * em eda.util.Constantes para inicializar os valores internos de sua estrutura.
 * Faca protected qualquer outro metodo auxiliar.
 *
 */
public class StackLinkedListImpl<E> implements Stack<E> {

	@SuppressWarnings("rawtypes")
	private SingleLinkedListRecursiveImpl array;	
	
	public StackLinkedListImpl() {
		array = new SingleLinkedListRecursiveImpl<E>();
	}
	
	/**
	 * Insere o elemento na pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void push(E element) throws ADTOverflowException {
		
		// tamanho inicial, tamanho atual, tamanho maximo

		if (!full()) {
			array.insert(element);
		} else {
			throw new ADTOverflowException();
		}

	}
	
	/**
	 * Remove o elemento da pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws ADTUnderflowException {
		E elementoRemovido = (E) new Object();
		
		if (isEmpty()) {
			throw new ADTUnderflowException();
		} else {
			// remove o ultimo elemento do array
			elementoRemovido = (E) array.removeLast();
		}
		return elementoRemovido;
	}

	/**
	 * Retorna o elemento que esta no topo da pilha.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E top() {
		E top = null;
		
		try {
			top = (E) array.last();
		} catch (ADTUnderflowException e) {
			top = null;
		}
		
		return top;
	}

	/**
	 * Retorna o tamanho da pilha.
	 */
	@Override
	public int size() {
		return array.size();
	}

	/**
	 * Verifica se a pilha esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	/**
	 * Verifica se a pilha esta cheia.
	 */
	@Override
	public boolean full() {
		return array.full();
	}

	/**
	 * toArray
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray() {
		return (E[]) array.toArray();
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString(){
		return array.toString();		
	}
	
}
