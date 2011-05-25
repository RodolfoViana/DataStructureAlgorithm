package eda.linearADT;

import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;


/**
 * The interface of a (unordered) linked list.
 *
 * @param <E>
 */
public interface LinkedList<E> {

	public boolean isEmpty();
	
	public boolean full();
	
	/**
	 * Returns how much elements are in the list.
	 */
	public int size();
	
	/**
	 * Inserts a new element into the list. If the stack is full push returns a
	 * specific exception. Insertions put a new element at the end. 
	 */
	public void insert(E element) throws ADTOverflowException;
	
	/**
	 * Searchs an element in the list. If the element is not in the list 
	 * returns a specific exception.
	 * @return
	 */
	public int search(E element) throws ADTNoSuchElement;
	
	/**
	 * Removes an element of the list. If the element is not in the list 
	 * returns a specific exception.
	 */
	public void remove(E element);
	
	/**
	 * Returns a list with the reverse order of its elements.
	 */
	public LinkedList<E> revert();
	
	/**
	 * Gives the highest element of a list. If the list is empty returns a
	 * specific exception.
	 */
	public int maximum();
	
	/**
	 * Gives the lowest element of a list. If the list is empty returns a
	 * specific exception.
	 */
	public int minimum();
	
	/**
	 * Returns a String containing the elements of the structure in order. 
	 * (from the first element to the last). The string must be the format [x1,...,xn] 
	 * where xi is an element of the list. 
	 */
	public E[] toArray();
}
