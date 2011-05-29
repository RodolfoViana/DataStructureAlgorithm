package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eda.linearADT.DoubleLinkedListNonRecursiveImpl;
import eda.util.ADTOverflowException;

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
	
	
	

}
