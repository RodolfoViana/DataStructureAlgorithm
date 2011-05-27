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

	@Override
	public void push(E element) throws ADTOverflowException {
		// TODO Auto-generated method stub

	}

	@Override
	public E pop() throws ADTUnderflowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

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
	public E[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
