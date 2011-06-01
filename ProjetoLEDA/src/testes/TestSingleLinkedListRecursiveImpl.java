package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.SingleLinkedListRecursiveImpl;
import eda.util.ADTNoSuchElement;
import eda.util.ADTOverflowException;

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
	
	
}
