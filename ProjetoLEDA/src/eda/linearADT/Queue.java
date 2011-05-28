package eda.linearADT;

import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * Interface of a Queue
 */
public interface Queue<E> {
	/**
	 * Puts a new element into the queue. If the queue is full enqueue returns a
	 * specific exception.
	 */
	public void enqueue(E element) throws ADTOverflowException;
	
	
	/**
	 * Remove the head element of a queue. If the queue is empty dequeue returns a
	 * specific exception. 
	 */
	public E dequeue() throws ADTUnderflowException;
	
	/**
	 * Returns the element of a queue without removing it. If the queue is empty dequeue returns a
	 * specific exception. 
	 */
	public E head() throws ADTUnderflowException;
	
	/**
	 * Returns the how much elements are in the structure.  
	 */
	public int size(); 
	
	public boolean isEmpty();
	
	public boolean full();
	
	/**
	 * Returns an array containing the elements of the queue in the same order
	 * they were put into (temporal order). The string must be the format [x1,...,xn] 
	 * where xi is an element of the queue. 
	 */
	public E[] toArray();
}
