package testes;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.DoubleLinkedListNonRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

public class TestDoubleLinkedListNonRecursiveImpl {
	
	DoubleLinkedListNonRecursiveImpl<Integer> linkedList;
	
	@Before public void construtor(){
		linkedList = new DoubleLinkedListNonRecursiveImpl<Integer>();
	}
	
	@Test public void isEmpty(){
		Assert.assertTrue(linkedList.isEmpty());
	}
	
	@Test public void insert() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		linkedList.insert(10);
		Assert.assertEquals("Erro no insert", 1, linkedList.size());
		linkedList.insert(15);
		Assert.assertEquals("Erro no insert", 2, linkedList.size());		
	}
	
	@Test public void minimum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(0);
		linkedList.insert(4);
		linkedList.insert(1);
		
		Assert.assertEquals("Minimum esta errado", 0, linkedList.minimum());
	} 
	
	@Test public void maximum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Maximum esta errado", 30, linkedList.maximum());
	} 
	
	@Test public void search() throws ADTOverflowException, ADTNoSuchElement{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("search esta errado", 3, linkedList.search(3));
		Assert.assertEquals("search esta errado", 2, linkedList.search(2));
		Assert.assertEquals("search esta errado", 30, linkedList.search(30));
		Assert.assertEquals("search esta errado", 4, linkedList.search(4));
		
	} 
	
	@Test public void remove() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		linkedList.remove(2);
		Assert.assertEquals("Erro no remove", "{3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 3, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.remove(4);
		Assert.assertEquals("Erro no remove", "{3,30}", linkedList.toString());
		Assert.assertEquals("Erro no size", 2, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.remove(30);
		Assert.assertEquals("Erro no remove", "{3}", linkedList.toString());
		Assert.assertEquals("Erro no size", 1, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.remove(3);
		Assert.assertEquals("Erro no remove", "{}", linkedList.toString());
		Assert.assertEquals("Erro no size", 0, linkedList.size());
		Assert.assertTrue(linkedList.isEmpty());
		
	}
	
	@Test public void revert() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		Assert.assertEquals("Erro no revert", "{4,30,3,2}", linkedList.revert().toString());
	}
	
	@Test public void toArray() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[4];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 30;
		aux[3] = 4;
				
		Assert.assertArrayEquals("Revert errado", aux, linkedList.toArray() );
	}
	
	@Test public void isHead() throws ADTOverflowException{
		Assert.assertFalse("Erro no isHead", linkedList.isHead());
		linkedList.insert(10);
		Assert.assertTrue("Erro no isHead", linkedList.isHead());
	}

	@Test public void addFirst() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.addFirst(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		linkedList.addFirst(10);
		
		Assert.assertEquals("Erro no toString", "{10,2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 5, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
	}
	
	@Test public void addLast() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.addLast(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		linkedList.addLast(40);
		Assert.assertEquals("Erro no toString", "{2,3,30,4,40}", linkedList.toString());
		Assert.assertEquals("Erro no size", 5, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
	}
	
	@Test public void removeFirst() throws ADTOverflowException, ADTUnderflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		linkedList.removeFirst();
		Assert.assertEquals("Erro no toString", "{3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 3, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeFirst();
		Assert.assertEquals("Erro no toString", "{30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 2, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeFirst();
		Assert.assertEquals("Erro no toString", "{4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 1, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeFirst();
		Assert.assertEquals("Erro no toString", "{}", linkedList.toString());
		Assert.assertEquals("Erro no size", 0, linkedList.size());
		Assert.assertTrue(linkedList.isEmpty());
		
	}
	
	@Test public void removeLast() throws ADTOverflowException, ADTUnderflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		linkedList.removeLast();
		Assert.assertEquals("Erro no toString", "{2,3,30}", linkedList.toString());
		Assert.assertEquals("Erro no size", 3, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeLast();
		Assert.assertEquals("Erro no toString", "{2,3}", linkedList.toString());
		Assert.assertEquals("Erro no size", 2, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeLast();
		Assert.assertEquals("Erro no toString", "{2}", linkedList.toString());
		Assert.assertEquals("Erro no size", 1, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		linkedList.removeLast();
		Assert.assertEquals("Erro no toString", "{}", linkedList.toString());
		Assert.assertEquals("Erro no size", 0, linkedList.size());
		Assert.assertTrue(linkedList.isEmpty());
		
	}
	
	@Test public void full() throws ADTOverflowException{
		
		for (int i = 0; i < 99; i++){
			linkedList.insert(i);
		}
	
		Assert.assertFalse(linkedList.full());
		linkedList.insert(100);
		Assert.assertTrue(linkedList.full());
	}

	@Test public void insertException() throws ADTOverflowException{
		for (int i = 0; i < 99; i++){
			linkedList.insert(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.insert(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.insert(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	} 

	@Test public void searchException() throws ADTOverflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro no toString", "{2,3,30,4}", linkedList.toString());
		Assert.assertEquals("Erro no size", 4, linkedList.size());
		Assert.assertFalse(linkedList.isEmpty());
		
		try {
			linkedList.search(10);
		} catch (ADTNoSuchElement e){
			Assert.assertEquals("No such element is in the structure", e.getMessage());
		}
	}

	@Test public void addFirstException() throws ADTOverflowException {
		for (int i = 0; i < 99; i++){
			linkedList.addFirst(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.addFirst(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.addFirst(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}

	@Test public void addLastException() throws ADTOverflowException {
		for (int i = 0; i < 99; i++){
			linkedList.addLast(i);
		}
		
		Assert.assertFalse(linkedList.full());
		linkedList.addLast(100);
		
		
		try {
			Assert.assertTrue(linkedList.full());
			Assert.assertEquals("Erro no size", 100, linkedList.size());
			linkedList.addLast(101);
		} catch (ADTOverflowException e){
			Assert.assertEquals("Structure is full", e.getMessage());
		}
	}
	
	@Test public void removeFirstException() {
		Assert.assertTrue(linkedList.isEmpty());
		
		try {
			linkedList.removeFirst();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}
	
	@Test public void removeLastException() {
		Assert.assertTrue(linkedList.isEmpty());
		
		try {
			linkedList.removeLast();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Structure is empty", e.getMessage());
		}
	}
}
