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
 *          Implementacao da Classe Fila
 */



/**
 * Fila que guarda elementos seguindo a politica FIFO. Implementar com array
 * puro. A fila deve ter um tamanho inicial, um tamanho maximo que pode crescer
 * e um FATOR de crescimento. Quando instanciada a fila tem um tamanho inicial.
 * Quando ela vai crescendo e enche, ela aumenta de tamanho de acordo com o
 * fator de crescimento desde que nao atinja ou ultrapasse o tamanho maximo. A
 * partir dai a estrutura nao pode mais crescer e pode ficar cheia. Use as
 * constrantes definidas em eda.util.Constantes para inicializar os valores
 * internos de sua estrutura. Faca protected qualquer outro metodo auxiliar.
 * 
 */
public class QueueImpl<E> implements Queue<E> {

	private int index;
	private E[] array;
	private int tamanhoInicial;
	private int tamanhoAtual;
	private int tamanhoMaximo;
	private final int FATOR = Constants.INCREASING_FACTOR;

	/**
	 * Construtor da Fila
	 */
	@SuppressWarnings("unchecked")
	public QueueImpl() {
		tamanhoInicial = Constants.INITIAL_SIZE_OF_STRUCTURE;
		tamanhoMaximo = Constants.MAX_SIZE_OF_STRUCTURE;
		array = (E[]) new Object[tamanhoInicial];
		tamanhoAtual = array.length;
	}
	
	/**
	 * Metodo que enfileira um elemento na fila, seguindo a politica FIFO.
	 */
	@Override
	public void enqueue(E element) throws ADTOverflowException {

		// metodo refeito		
		if (!full()) {
			if (counter() == array.length -1 || counter() == array.length) {
				aumentaTamanhoFila();
				array[index++] = element;
			} else { 
				array[index++] = element;
			}
		} else {
			throw new ADTOverflowException();
		}
	}

	/**
	 * Metodo que remove o elemento da fila e retorna o proximo elemento
	 * subsequente, seguindo a politica FIFO.
	 */
	@Override
	public E dequeue() throws ADTUnderflowException {
		@SuppressWarnings("unchecked")
		E elementoRemovido = (E) new Object();
		// se a fila estiver vazia 
		if (isEmpty()) {
			throw new ADTUnderflowException();
		} else {
			// caso contrario, encontra o elemento a ser removido e faz o shift left
			elementoRemovido = array[0];
			array[1] = null;
			shiftLeft();
		}
		return elementoRemovido;
	}

	/**
	 * Retorna o elemento posicionado no inicio da fila.
	 */
	@Override
	public E head() throws ADTUnderflowException{
		if (isEmpty()){ 
			 throw new ADTUnderflowException();
		}
		return array[1];
	}
	
	/**
	 * 
	 * @return a quantidade de espacos alocados no array
	 */
	protected int counter() {
		int counter = 0;
		for (int i = 0; i <= array.length - 1; i++) {
			if (array[i] != null) {
				counter++;
			}
		}
		return counter;
	}
	

	/**
	 * Retorna o numero de elementos presentes da fila.
	 */
	@Override
	public int size() {
		return counter();
	}

	/**
	 * Verifica se a fila esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return counter() == 0;
	}

	/**
	 * Verifica se a fila esta cheia.
	 */
	@Override
	public boolean full() {
		return counter() == tamanhoMaximo;
	}

	/**
	 * Retorna o array contendo os elementos que estao na fila.
	 */
	@Override
	public E[] toArray() {
		return array;
	}

	/**
	 * Metodo que desloca para a fila para a esquerda em um elemento
	 */
	protected void shiftLeft() {
		for (int i = 0; i <= counter(); i++) {
			array[i] = array[i + 1];
		}
		index--;
	}

	/**
	 * Metodo que proporciona o crescimento da fila utilizando um fator de
	 * crescimento.
	 */
	@SuppressWarnings("unchecked")
	protected void aumentaTamanhoFila() {
		// TAMANHO MAXIMO = 100 TAMANHO INICIAL = 30 FATOR = 20
		// se o numero de espacos alocados no array foi igual ao seu proprio tamanho, aumenta
		
			E[] array2 = (E[]) new Object[array.length];
				
			// joga os elementos do array menor pro maior
			for (int i = 0; i <= array.length; i++) {
				array2[i] = array[i];
			}
			
			// refaz o array menor com o tamanho novo  (tamanho antigo + fator)
			// se o numero de alocacoes for 90, so pode por mais 10
			if (counter() == 90) {
				array = (E[]) new Object[array.length + 10];
			} else {
				array = (E[]) new Object[array.length + FATOR];
			}
			
			// joga os elementos do array2 pro array 1
			for (int i = 0; i < array2.length; i++) {
				array[i] = array2[i];
			}
	}

	public String toString() {
		if (isEmpty()) 
			return "[]";
		
		String impressao = "[";
		for (int i = 0; i <= array.length - 1; i++) {
			if (array[i] != null)
				impressao += array[i] + ", ";

		}
		return impressao.substring(0, impressao.length() - 2) + "]";
	}
}
