package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.SingleLinkedListRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

public class TestSingleLinkedListRecursiveImpl {
	
	private SingleLinkedListRecursiveImpl<Integer> linkedList;
	
	@Before public void construtor(){
		linkedList = new SingleLinkedListRecursiveImpl<Integer>();
	}
	
	@Test public void isEmpty(){
		Assert.assertTrue(linkedList.isEmpty());
	}
	
	@Test public void insert() throws ADTOverflowException{
		linkedList.insert(10);
		Assert.assertEquals("Nao ta inserindo", 1, linkedList.size());
		linkedList.insert(15);
		Assert.assertEquals("Nao ta inserindo", 2, linkedList.size());
	}
	
	@Test public void search() throws ADTOverflowException, ADTNoSuchElement{
		linkedList.insert(20);
		linkedList.insert(30);
		linkedList.insert(40);
		
		Assert.assertEquals("Nao ta procurando", 40, linkedList.search(40));
		Assert.assertEquals("Nao ta procurando", 30, linkedList.search(30));
		Assert.assertEquals("Nao ta procurando", 20, linkedList.search(20));
	}
	
	@Test public void remove() throws ADTOverflowException {
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Nao ta inserindo", 3, linkedList.size());
		linkedList.remove(4);
		Assert.assertEquals("Nao ta removendo", 2, linkedList.size());
		linkedList.remove(3);
		Assert.assertEquals("Nao ta removendo", 1, linkedList.size());
		linkedList.remove(2);
		Assert.assertEquals("Nao ta removendo", 0, linkedList.size());
		
	}
	
	@Test public void revert() throws ADTOverflowException{
		Integer n1 = new Integer(2);
		Integer n2 = new Integer(3);
		Integer n3 = new Integer(4);
		
		linkedList.insert(n1);
		linkedList.insert(n2);
		linkedList.insert(n3);
		
		SingleLinkedListRecursiveImpl<Integer> linkedList2 = new SingleLinkedListRecursiveImpl<Integer>();
		
		linkedList2.insert(n3);
		linkedList2.insert(n2);
		linkedList2.insert(n1);
				
		Assert.assertEquals("Revert errado", "{4,3,2}", linkedList.revert().toString());
	}
	
	@Test public void maximum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(30);
		linkedList.insert(4);
		
		Assert.assertEquals("Minimum esta errado", 30, linkedList.maximum());
	} 
	
	@Test public void minimum() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(0);
		linkedList.insert(4);
		linkedList.insert(1);
		
		Assert.assertEquals("Minimum esta errado", 0, linkedList.minimum());
	} 
	
	@Test public void removeLast() throws ADTOverflowException, ADTUnderflowException{
		Integer n1 = 2;
		Integer n2 = 3;
		Integer n3 = 0;
		Integer n4 = 4;
		Integer n5 = 1;
		
		linkedList.insert(n1);
		linkedList.insert(n2);
		linkedList.insert(n3);
		linkedList.insert(n4);
		linkedList.insert(n5);
			
		Assert.assertEquals("removeLast esta errado", n5, linkedList.removeLast());
	} 
	
	@Test public void last() throws ADTOverflowException, ADTUnderflowException{
		Integer n1 = 2;
		Integer n2 = 3;
		Integer n3 = 0;
		Integer n4 = 4;
		Integer n5 = 1;
		
		linkedList.insert(n1);
		linkedList.insert(n2);
		linkedList.insert(n3);
		linkedList.insert(n4);
		linkedList.insert(n5);
		
		Assert.assertEquals("last esta errado", n5, linkedList.last());
	} 
	
	@Test public void toArray() throws ADTOverflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[3];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
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
	
	@Test public void lastException() throws ADTOverflowException, ADTUnderflowException{
		Assert.assertTrue(linkedList.isEmpty());
		
		try{
			linkedList.last();
		} catch (ADTUnderflowException e) {
			Assert.assertEquals("Erro no last", "Structure is empty", e.getMessage());
		}	
	}


}
