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
 * 			Pilha - Implementacao Nao-Recursiva
 */

/**
 * Estrutura que guarda elementos seguindo a politica LIFO (last in-first out
 * (ultimo a entrar, primeiro a sair)). Implementar com array puro. tamanho
 * inicial, tamanho maximo, um FATOR de crescimento. Quando instanciada a
 * estrutura tem um tamanho inicial. Quando ela vai crescendo e enche, ela
 * aumenta de tamanho de acordo com o fator de crescimento desde que nao atinja
 * ou ultrapasse o tamanho maximo. A partir dai a estrutura nao pode mais
 * crescer e pode ficar cheia. Use as constrantes definidas em eda.util.
 * 
 * Constantes para inicializar os valores internos de sua estrutura. Faca
 * protected qualquer outro metodo auxiliar.
 * 
 */

public class StackImpl<E> implements Stack<E> {

	private E[] array;
	private int tamanhoInicial;
	private int tamanhoAtual;
	private int tamanhoMaximo;
	private final int FATOR = Constants.INCREASING_FACTOR;

	/**
	 * Construtor da pilha
	 */
	@SuppressWarnings("unchecked")
	public StackImpl() {
		tamanhoInicial = Constants.INITIAL_SIZE_OF_STRUCTURE;
		tamanhoMaximo = Constants.MAX_SIZE_OF_STRUCTURE;
		array = (E[]) new Object[tamanhoInicial];
	}

	/**
	 * Metodo que proporciona o crescimento do array com base no FATOR
	 * 
	 * @param FATOR
	 *            Parametro de crescimento do array
	 */
	@SuppressWarnings("unchecked")
	protected void aumentaTamanho() {

		if ((array.length < tamanhoMaximo)) {
			this.tamanhoAtual = (tamanhoAtual + FATOR);

			// cria um novo array com o tamanho maior
			E[] array2 = (E[]) new Object[tamanhoAtual];

			// transfere os dados do array antigo pro array novo
			for (int i = 0; i <= array.length; i++) {
				array2[i] = array[i];
			}

			// instancia novamente
			array = (E[]) new Object[tamanhoAtual];

			// migra os dados
			for (int i = 0; i < array2.length; i++) {
				array[i] = array2[i];
			}
		}
	}

	/**
	 * Metodo que adiciona o elemento na pilha, retornando excessao caso a
	 * estrutura esteja cheia.
	 */
	@Override
	public void push(E element) throws ADTOverflowException {
		if (!full()) {
			if (array.length == tamanhoAtual) {
				aumentaTamanho();
				array[array.length + 1] = element; // element getValor()
			} else {
				array[array.length + 1] = element; // element getValor()
			}
		} else {
			throw new ADTOverflowException();
		}
	}

	/**
	 * @return O elemento que foi removido da pilha
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E pop() throws ADTUnderflowException {
		E elementoRemovido = (E) new Object();
		if (isEmpty()) {
			throw new ADTUnderflowException();
		} else {
			elementoRemovido = array[tamanhoAtual];
			array[tamanhoAtual] = null;
			tamanhoAtual--;
		}
		return elementoRemovido;
	}

	/**
	 * retorna um array contendo todos os elementos da pilha do elemento mais
	 * antigo para o elemento mais novo.
	 */
	@Override
	public E[] toArray() {
		return array;
	}

	/**
	 * @return O elemento que esta no topo da pilha
	 */
	@Override
	public E top() throws ADTUnderflowException {
		if (isEmpty())
			throw new ADTUnderflowException();
		return array[tamanhoAtual];
	}

	/**
	 * @return True caso a pilha esteja vazia, false caso contrario
	 */
	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}

	/**
	 * @return True caso a pilha esteja cheia, false caso contrario
	 */
	@Override
	public boolean full() {
		return array.length == tamanhoMaximo;
	}

	/**
	 * @return O numero de elementos da pilha
	 */
	@Override
	public int size() {
		return array.length;
	}
}
