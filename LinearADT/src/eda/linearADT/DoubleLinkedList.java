package eda.linearADT;

import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;


public interface DoubleLinkedList<E> extends LinkedList<E> {

	/**
	 * Says if this list is the head of a double linked list. If the list 
	 * is empty it does not have the head element.
	 */
	public abstract boolean isHead();

	/**
	 * Adds a new element in the head of this list.   
	 */
	public abstract DoubleLinkedList<E> addFirst(int numero) throws ADTOverflowException;

	/**
	 * Adds a new element in the last position of this list.   
	 */
	public abstract void addLast(int numero) throws ADTOverflowException;

	/**
	 * Removes the first element of this list.    
	 */
	public abstract void removeFirst() throws ADTUnderflowException;

	/**
	 * Removes the last element of this list.    
	 */
	public abstract void removeLast() throws ADTUnderflowException;
	
}
