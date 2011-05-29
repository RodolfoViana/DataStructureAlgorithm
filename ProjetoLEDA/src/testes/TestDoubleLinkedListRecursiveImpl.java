package testes;

import eda.linearADT.DoubleLinkedListRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;
import eda.util.ADTUnderflowException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDoubleLinkedListRecursiveImpl {
	
	private DoubleLinkedListRecursiveImpl<Integer> linkedList;
	
	@Before public void construtor(){
		linkedList = new DoubleLinkedListRecursiveImpl<Integer>();
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
		
		DoubleLinkedListRecursiveImpl<Integer> linkedList2 = new DoubleLinkedListRecursiveImpl<Integer>();
		linkedList2.insert(n3);
		linkedList2.insert(n2);
		linkedList2.insert(n1);
				
		Assert.assertTrue("Revert errado", linkedList2.equals(linkedList.revert()) );
		
	}
	
	@Test public void isHead() throws ADTOverflowException{
		Assert.assertFalse(linkedList.isHead());
		linkedList.insert(10);
		Assert.assertTrue(linkedList.isHead());
	}
	
	@Test public void addFirst() throws ADTOverflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[3];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		
		
		
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
		
//		linkedList.addFirst(10);
//		
//		aux = new Integer[4];
//		aux[0] = 10;
//		aux[1] = 2;
//		aux[2] = 3;
//		aux[3] = 4;
//		
//		Assert.assertArrayEquals(aux, linkedList.toArray());

//		
//		DoubleLinkedListRecursiveImpl<Integer> linkedList2 = new DoubleLinkedListRecursiveImpl<Integer>();
//		linkedList2.insert(2);
//		linkedList2.insert(3);
//		linkedList2.insert(4);
//		
//		
		
	}
	
	@Test public void addLast() throws ADTOverflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Integer[] aux = new Integer[3];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
		
		linkedList.addLast(10);
		
		aux = new Integer[4];
		aux[0] = 2;
		aux[1] = 3;
		aux[2] = 4;
		aux[3] = 10;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	@Test public void removeLast() throws ADTOverflowException, ADTUnderflowException{
		
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro ao adicionar", 3, linkedList.size());
		
		linkedList.removeLast();
		
		Assert.assertEquals("Erro ao remover", 2, linkedList.size());
		
		Integer[] aux = new Integer[2];
		aux[0] = 2;
		aux[1] = 3;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	@Test public void removeFirt() throws ADTOverflowException, ADTUnderflowException{
		linkedList.insert(2);
		linkedList.insert(3);
		linkedList.insert(4);
		
		Assert.assertEquals("Erro ao adicionar", 3, linkedList.size());
		
		linkedList.removeFirst();
		
		Assert.assertEquals("Erro ao remover", 2, linkedList.size());
		

		Integer[] aux = new Integer[2];
		aux[0] = 3;
		aux[1] = 4;
		
		Assert.assertArrayEquals(aux, linkedList.toArray());
	}
	
	
	

}
