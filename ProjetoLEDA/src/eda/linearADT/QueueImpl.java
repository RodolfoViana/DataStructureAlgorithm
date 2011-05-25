package eda.linearADT;

/**
 * Universidade Federal de Campina Grande
 * Projetos de Laboratorio de Estrutura de Dados
 * 
 * Equipe:  Layse Sobreira
 * 			Renan Pinto
 * 			Rodolfo Viana
 * 			Talita Lobo
 *  
 * Implementacao da Classe Fila
 */
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;
import eda.util.Constants;

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
	private int tamanhoInicial;
	private int tamanhoAtual;
	private int tamanhoMaximo;
	private E[] array;
	private final int FATOR = Constants.INCREASING_FACTOR;

	/**
	 * Construtor da Fila
	 */
	@SuppressWarnings("unchecked")
	public QueueImpl() {
		tamanhoInicial = Constants.INITIAL_SIZE_OF_STRUCTURE;
		tamanhoMaximo = Constants.MAX_SIZE_OF_STRUCTURE;
		array = (E[]) new Object[tamanhoInicial];
	}

	/**
	 * Metodo que enfileira um elemento na fila, seguindo a politica FIFO.
	 */
	@Override
	public void enqueue(E element) throws ADTOverflowException {
		if (!full()) {
			if (array.length == tamanhoAtual) {
				aumentaTamanhoFila();
				array[++index] = element;
			} else {
				throw new ADTOverflowException();
			}
		}
	}

	/**
	 * Metodo que remove o elemento da fila e retorna o proximo elemento
	 * subsequente, seguindo a politica FIFO.
	 */
	@Override
	public E dequeue() throws ADTUnderflowException {
		E proximoElemento = (E) new Object();
		if (isEmpty()) {
			throw new ADTUnderflowException();
		}
		proximoElemento = array[0];
		shiftLeft();
		return proximoElemento;
	}

	/**
	 * Retorna o elemento posicionado no inicio da fila.
	 */
	@Override
	public E head() throws ADTUnderflowException{
		if (isEmpty()){ 
			 throw new ADTUnderflowException();
		}
		return array[tamanhoAtual];
	}

	/**
	 * Retorna o numero de elementos presentes da fila.
	 */
	@Override
	public int size() {
		return array.length;
	}

	/**
	 * Verifica se a fila esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return array.length == 0;
	}

	/**
	 * Verifica se a fila esta cheia.
	 */
	@Override
	public boolean full() {
		return array.length == tamanhoMaximo;
	}

	/**
	 * Retorna o array contendo os elementos que estao na fila.
	 */
	@Override
	public E[] toArray() {
		return array;
	}

	/**
	 * Metodo que desloca um elemento na fila.
	 */
	protected void shiftLeft() {
		for (int i = 0; i <= index; i++) {
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
		if (array.length < tamanhoMaximo) {
			this.tamanhoAtual = tamanhoAtual + FATOR;

			// Cria um novo array e passa os dados do array atual para um novo
			// array
			E[] arrayAux = (E[]) new Object[tamanhoAtual];
			for (int i = 0; i <= arrayAux.length; i++) {
				arrayAux[i] = array[i];
			}
			// Cria-se uma nova instancia
			array = (E[]) new Object[tamanhoAtual];
			// Migra-se os dados
			for (int i = 0; i < arrayAux.length; i++) {
				array[i] = arrayAux[i];
			}
		}
	}

}
