package eda.linearADT;

import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

/**
 * Interface of a Stack. 
 */
public interface Stack<E> {
	
	/**
	 * Puts a new element into the stack. If the stack is full push returns a
	 * specific exception.
	 */
	public void push(E element) throws ADTOverflowException;
	
	/**
	 * Remove the top element of a stack. If the stack is empty pop returns a
	 * specific exception. 
	 */
	public E pop() throws ADTUnderflowException;
	
	/**
	 * Returns the top element of a stack without removing it. If the stack 
	 * is empty top() returns a specific exception. 
	 */
	public E top();
	
	/**
	 * Returns the how much elements are in the structure.  
	 */
	public int size(); 

	public boolean isEmpty();
	public boolean full();
	
	/**
	 * Returns an array containing the elements of the stack (from the oldest element
	 * to the newest). The string must be the format [x1,...,xn] 
	 * where xi is an element of the stack and xn is the on the top. 
	 */
	public E[] toArray();
	
}
