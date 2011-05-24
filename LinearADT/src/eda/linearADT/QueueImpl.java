package eda.linearADT;

/**
 * Projeto de Lab de Est. de Dados
 * 
 * Equipe:
 * Layse Sobreira - 21115289
 * Renan Pinto - 
 * Rodolfo Viana -
 * Talita Lobo - 
 * 
 * Implementacao da Classe Fila
 */
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * Fila que guarda elementos seguindo a politica FIFO. Implementar com array puro.
 * A fila deve ter um tamanho inicial, um tamanho maximo que pode crescer e um FATOR 
 * de crescimento. Quando instanciada a fila tem um tamanho inicial. Quando ela vai 
 * crescendo e enche, ela aumenta de tamanho de acordo com o fator de crescimento
 * desde que nao atinja ou ultrapasse o tamanho  maximo. A partir dai a estrutura
 * nao pode mais crescer e pode ficar cheia. Use as constrantes definidas
 * em eda.util.Constantes para inicializar os valores internos de sua estrutura.
 * Faca protected qualquer outro metodo auxiliar.
 *
 */
public class QueueImpl<E> implements Queue<E> {

	private int index;
	private int[] array;

	@Override
	public void enqueue(E element) throws ADTOverflowException{
		// TODO Auto-generated method stub

	}

	@Override
	public E dequeue() throws ADTUnderflowException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E head() {
		return null;
	}

	@Override
	public int size(){
		return 0;
	} 
	
	/**
	 * Verifica se a fila esta vazia.
	 */
	@Override
	public boolean isEmpty() {
		return index == -1;
	}

	/**
	 * Verifica se a fila esta cheia.
	 */
	@Override
	public boolean full() {
		return index + 1 == array.length;
	}

	@Override
	public E[] toArray(){
		// TODO Auto-generated method stub
		return null;
	}
}
