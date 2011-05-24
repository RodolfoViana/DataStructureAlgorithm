package eda.linearADT;

import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * Estrutura que guarda elementos seguindo a politica FIFO, mas que utiliza
 * filas (Queue) internamente para guardar (e nao array puro). Pode usar quantas 
 * filas achar necessario, mas o limite minimo de 2 para essa implementacao.
 * A estrutura deve ter um tamanho inicial, um tamanho maximo que pode crescer e um FATOR 
 * de crescimento. Quando instanciada a estrutura tem um tamanho inicial. Quando ela vai 
 * crescendo e enche, ela aumenta de tamanho de acordo com o fator de crescimento
 * desde que nao atinja ou ultrapasse o tamanho  maximo. A partir dai a estrutura
 * nao pode mais crescer e pode ficar cheia. Use as constrantes definidas
 * em eda.util.Constantes para inicializar os valores internos de sua estrutura.
 * Faca protected qualquer outro metodo auxiliar.
 *
 */
public class StackQueueImpl<E> implements Stack<E> {

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
	public E[] toArray(){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}


}
