package testes;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.SingleLinkedListNonRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

public class TestSingleLinkedListNonRecursiveImpl {
	
	SingleLinkedListNonRecursiveImpl<Integer> linkedList;
	
	@Before public void construtor(){
		linkedList = new SingleLinkedListNonRecursiveImpl<Integer>();
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
		linkedList.insert(20);
		Assert.assertEquals("Erro no insert", 3, linkedList.size());
		Assert.assertEquals("Erro no toString", "{10,15,20}", linkedList.toString());
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
	
	@Test public void search() throws ADTOverflowException, ADTNoSuchElement {
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(5);
		linkedList.insert(4);

		Assert.assertEquals("search esta errado", 3, linkedList.search(3));
		Assert.assertEquals("search esta errado", 2, linkedList.search(2));
		Assert.assertEquals("search esta errado", 5, linkedList.search(5));
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
		
		@SuppressWarnings("unused")
		SingleLinkedListNonRecursiveImpl<Integer> linkedList2  = (SingleLinkedListNonRecursiveImpl<Integer>) linkedList.revert();
		
		Assert.assertEquals("Erro no revert", "{4,30,3,2}", linkedList2.toString());
	}
	
	@Test public void toArray() throws ADTOverflowException {
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
}
